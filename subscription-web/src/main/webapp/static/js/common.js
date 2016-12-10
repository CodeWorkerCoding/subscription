/*全站通用js*/

$(function(){
    /*
    * user:eve.yap
    * date:2016-4-23
    * description: 确认弹窗，使用时在a标签或button添加class“_confirm”, 并添加属性data-confirm="提示内容"
    * 注意: type="submit"的button应修改为type="button"
    * */
    $('a._confirm').each(function () { //alert('aaa');
        var confirmMsg = $(this).attr("data-confirm");
        $(this).confirm('',confirmMsg);
    });

    $('button._confirm').click(function(){
        var confirmMsg = $(this).attr("data-confirm");
        var obj = $(this).parent("form");
        $.confirm({
            title:confirmMsg,
            content:'',
            confirm: function () {
                obj.submit();
            }
        });
    });


});