    function checkUpdateUser()
    {
        var userName = $("#userName").val();
        var passWord = $("#passWord").val();
        var rightLevel = $("#rightLevel").val();

        if(userName.length==0){
           alert("用户名不能为空");
           return;
         }
        if(passWord.length==0){
           alert("密码不能为空");
           return;
         }
         if(rightLevel.length==0){
           alert("用户权限不能为空");
           return;
         }else if(rightLevel<1||rightLevel>3){
           alert("用户权限只能在1～3之间的整数");a
           return;
         }
    }

    function alertWrongMessage(wrongMessage)
    {
          alert(wrongMessage);
    }

    function changeFollowRecordStatus(){

         var followRecordDiv=document.getElementById("followRecordDiv");
         var style=followRecordDiv.style.display;

         if(style=='none'){
            followRecordDiv=document.getElementById("followRecordDiv").style.display='block';
         }else{
            followRecordDiv=document.getElementById("followRecordDiv").style.display='none';
         }
    }


$(".table").find(".dbclicktd").bind("dblclick", function () {
        var input = "<input type='text' id='temp' style='width:130px;' value=" + $(this).text() + " >";
        $(this).text("");
        $(this).append(input);
        $("input#temp").focus();
        $("input").blur(function () {
            if ($(this).val() == "") {
                $(this).remove();
            } else {
                $(this).closest("td").text($(this).val());
            }
        });
    });

        //jquery初始化
    $(function() {
        var wrongMessage = $('#wrongMessage').val();
        if(wrongMessage!=undefined){
            alert(wrongMessage)
        }
    });
