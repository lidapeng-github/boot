$(function () {


    $("#emp").blur(function () {
        var value = this.value;
        $.getJSON("examine",value,function (data) {
            if (data){
                $("span.span").text("✘");
            }else{
                $("span.span").text("✔");
            }
        });
    })


})