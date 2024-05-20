<%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/02
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
        #showing{
            position: absolute;
            top: 100px;
            left: 450px;
            width: 200px;
        }
    </style>
    <script type="text/javascript">
        // 파일업로드 미리보기 함수
        function preview(tag){
            if(tag.files[0]){
                let f=tag.files[0];

                if(!f.type.match("image.*")){
                    alert("이미지 파일만 가능합니다");
                    return;
                }
                if(f){
                    let reader=new FileReader();
                    reader.onload=function(e){
                        $("#showimg").attr("src",e.target.result);
                    }
                    reader.readAsDataURL(tag.files[0]);
                }
            }
        }
    </script>
</head>
<body>
<div style="margin: 20px;width: 400px;">
    <form action="memoaction.jsp" method="post" enctype="multipart/form-data">
        <table class="table table-bordered">
            <tr>
                <th width="100" class="table-danger">제목</th>
                <td>
                <input type="text" name="title" class="form-control"
                       required="required">
                </td>
            </tr>
            <tr>
                <th width="100" class="table-danger">사진업로드</th>
                <td>
                    <input type="file" name="upload"
                     onchange="preview(this)" style="width: 200px;">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea style="width: 100%;height: 100px;"
                              name="content" class="form-control"
                              required="required"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-secondary">메모저장</button>
                </td>
            </tr>
        </table>
        <img id="showimg" src="" onerror="this.src='../image/noimage_pre.png'"><!--미리보기용-->
    </form>
</div>
</body>
</html>
