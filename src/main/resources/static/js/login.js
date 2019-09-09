    function checkLogin()
    {
        var userName = $("#userName").val();
        var passWord = $("#passWord").val();

        if(userName.length==0){
           alert("用户名不能为空");
           return;
         }
        if(passWord.length==0){
           alert("密码不能为空");
           return;
         }
    }
    function alertWrongMessage(wrongMessage)
    {
          alert(wrongMessage);
    }

//jquery初始化
        $(function() {
//        if()
var a = $('#harden').val();
//alert(session.getAttribute("wrongMessage"));
//alert(${session.wrongMessage});
alert(a)
        // 初始化内容
                     });
