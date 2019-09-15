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

        //jquery初始化
    $(function() {
        var wrongMessage = $('#wrongMessage').val();
        if(wrongMessage!=undefined){
            alert(wrongMessage)
        }
    });
