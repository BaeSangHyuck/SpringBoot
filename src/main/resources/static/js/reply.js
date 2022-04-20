/*
* reply modules
*
* Javascript 모듈화
*   함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
*   화면 내에서 Javascript 처리를 하다 보면 이벤트 처리와 DOM, Ajax 처리 등
*   복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript를 하나의 모듈처럼 구성하여 사용한다.
*
* */
// console.log("Reply Modules.......");

let replyService = (function(){

    //댓글 추가
    function add(reply, callback, error) {
        console.log("add reply..........")
        $.ajax({
            type: "POST",
            url: "/replies/new",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }
    
    //댓글 목록
    function getList(param, callback, error){
        let bno = param.bno;
        let page = param.page || 1;

        $.getJSON("/replies/list/" + bno + "/" + page, function(replyPageDTO){
            if(callback){
                callback(replyPageDTO.replyCount, replyPageDTO.list);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        });

        // $.ajax({
        //     type: "GET",
        //     url: "/replies/list/" + bno + "/" + page,
        //     success: function (list) {
        //         if (callback) {
        //             callback(list);
        //         }
        //     },
        //     error: function (xhr, status, er) {
        //         if (error) {
        //             error(er);
        //         }
        //     }
        // });
    }

    //댓글 조회
    function read(rno, callback, error){
        $.get("/replies/" + rno, function(result){
            if(callback){
                callback(result);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        })
    }

    //댓글 삭제
    function remove(rno, callback, error){
        $.ajax({
            type: "DELETE",
            url: "/replies/" + rno,
            success: function(result) {
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 수정
    function modify(reply, callback, error){
        $.ajax({
            type: "PATCH",
            url: "/replies/" + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 작성 시간(Controller)
    function getReplyDateByController(replyDate, callback, error){
        $.ajax({
            type: "GET",
            url: "/time",
            data: {replyDate : replyDate},
            success: function(date){
                if(callback){
                    callback(date);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 작성 시간(Javascript)
    function getReplyDateByJavascript(replyDate){
        let today = new Date();
        let rDate = new Date(replyDate);
        let gap = today.getTime() - rDate.getTime();

        if(gap < 1000 * 60 * 60 * 24){
            let h = rDate.getHours();
            let mm = rDate.getMinutes();
            let s = rDate.getSeconds();

            return [(h < 10 ? '0' : '') + h, ':', (mm < 10 ? '0' : '') + mm, ':', (s < 10 ? '0' : '') + s].join("");
        }else{
            let y = rDate.getFullYear();
            let m = rDate.getMonth() + 1;
            let d = rDate.getDate();

            return [y, '-', (m < 10 ? '0' : '') + m, '-', (d < 10 ? '0' : '') + d].join("");
        }
    }

    return {add: add, getList: getList, read: read, remove: remove, modify: modify, getReplyDateByController: getReplyDateByController, getReplyDateByJavascript: getReplyDateByJavascript}
})();
