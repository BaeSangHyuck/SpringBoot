/*
 * 문제점
 *   1. 동일한 이름으로 파일이 업로드 되었을 때 기존 파일이 사라지는 문제
 *   2. 이미지 파일의 경우 원본 파일의 용량이 큰 경우 썸네일 이미지를 생성해야 하는 문제
 *   3. 이미지 파일과 일반 파일을 구분해서 다운로드 혹은 페이지에서 조회하도록 처리하는 문제
 *   4. 첨부파일 공격에 대비하기 위한 업로드 파일의 확장자 제한
 * */
package com.example.board.controller;

import com.example.board.domain.vo.AttachVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/upload/*")
public class AttachController {

    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public List<AttachVO> uploadAjaxPost(MultipartFile[] uploadFile){
        String uploadFolder = "C:/upload";
        List<AttachVO> fileList = new ArrayList<>();
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        for(MultipartFile file : uploadFile){
            log.info("-------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            AttachVO AttachVO = new AttachVO();
            uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();

            AttachVO.setFileName(uploadFileName);
            AttachVO.setUuid(uuid.toString());
            AttachVO.setUploadPath(uploadFolderPath);

            //저장할 경로와 파일의 이름을 File객체에 담는다.
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                //설정한 경로에 해당 파일을 업로드한다.
                file.transferTo(saveFile);
//                InputStream in = new FileInputStream(saveFile);

                if(checkImageType(saveFile)){
                    AttachVO.setImage(true);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//                    Thumbnailator.createThumbnail(in, thumbnail, 100, 100);
                    Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
                    thumbnail.close();
                }
                fileList.add(AttachVO);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return fileList;
    }

    //    @GetMapping("/display")
//    @ResponseBody
//    public ResponseEntity<byte[]> getFile(String fileName){
//        File file = new File("C:/upload/" + fileName);
//        HttpHeaders header = new HttpHeaders();
//        ResponseEntity<byte[]> result = null;
//        try {
////            헤더에 적절한 파일의 타입을 probeContentType을 통해서 포함시킨다.
////            png파일이면 image/png, jpeg파일이면 image/jpeg 타입으로 포함시킨다.
//            header.add("Content-Type", Files.probeContentType(file.toPath()));
//            result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> download(String fileName){
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders header = new HttpHeaders();
        String name = resource.getFilename();
        name = name.substring(name.indexOf("_") + 1);
//        브라우저에 다운로드 될 파일의 저장 정보를 설정한다.
        try {
            header.add("Content-Disposition", "attachment; filename=" + new String(name.getBytes("UTF-8"), "ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }

    @PostMapping("/deleteFile")
    @ResponseBody
    public String deleteFile(String fileName, String type){
        File file = new File("C:/upload/" + fileName);
        file.delete();
        if(type.equals("image")){
            file = new File(file.getPath().replace("s_", ""));
            file.delete();
        }
        return "deleted";
    }

    private String getPath(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }

    private boolean checkImageType(File file){
        try {
            //헤더에 담긴 파일의 ContentType을 가져온다.
            //startsWith()를 사용해서 image라는 문자열로 시작한다면 true리턴, 아니면 false리턴
            return Files.probeContentType(file.toPath()).startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}









