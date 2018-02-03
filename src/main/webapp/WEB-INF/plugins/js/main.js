/**
 * Created by Saul on 11/18/16.
 */
define(["common"], function (p) {
    require(["jquery", "ligerui", "message_bundle"], function (min) {
        $("#main").ligerLayout();
        showIframe("detail", "#detailPage", "app", $("#detailPage").width(), $("#detailPage").height());
    });
});
function showIframe(name, appendto, url, w, h) {
    //添加iframe
    var if_w = w;
    var if_h = h;
    //allowTransparency='true' 设置背景透明
    $("<iframe width='" + if_w + "' height='" + if_h + "' id='" + name + "' name='" + name + "' style='position:absolute;z-index:4;'  frameborder='no' marginheight='0' marginwidth='0' allowTransparency='true'></iframe>").prependTo(appendto);
    var st = document.documentElement.scrollTop || document.body.scrollTop;//滚动条距顶部的距离
    var sl = document.documentElement.scrollLeft || document.body.scrollLeft;//滚动条距左边的距离
    var ch = document.documentElement.clientHeight;//屏幕的高度
    var cw = document.documentElement.clientWidth;//屏幕的宽度
    var objH = $("#" + name + "").height();//浮动对象的高度
    var objW = $("#" + name + "").width();//浮动对象的宽度
    var objT = Number(st) + (Number(ch) - Number(objH)) / 4;
    var objL = Number(sl) + (Number(cw) - Number(objW)) / 4;
    $("#" + name + "").css('left', objL);
    $("#" + name + "").css('top', objT);
    $("#" + name + "").attr("src", url)
}