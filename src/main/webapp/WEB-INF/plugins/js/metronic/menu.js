(function ($) {
    $.fn.sidebarMenu = function (options) {
        options = $.extend({}, $.fn.sidebarMenu.defaults, options || {});
        var target = $(this);
        // target.parent().addClass('page-sidebar');
        if (options.data) {
            init(target, options.data);
        }
        else {
            if (!options.url) return;
            $.getJSON(options.url, options.param, function (data) {
                init(target, data);
            });
        }
        var url = window.location.pathname;
        //menu = target.find("[href='" + url + "']");
        //menu.parent().addClass('active');
        //menu.parent().parentsUntil('.nav-list', 'li').addClass('active').addClass('open');
        function init(target, data) {
            $.each(data, function (i, item) {
                var li = $('<li class="nav-item "></li>');
                if (i == 0) {
                    li = $('<li class="nav-item start "></li>');
                }
                var a = $('<a></a>');
                var icon = $('<i></i>');
                //icon.addClass('glyphicon');
                icon.addClass(item.icon);
                var text = $('<span></span>');
                text.addClass('title').text(item.text);
                a.append(icon);
                a.append(text);
                if (item.menus && item.menus.length > 0) {
                    a.attr('href', 'javascript:;');
                    a.addClass('nav-link nav-toggle');
                    var arrow = $('<span></span>');
                    arrow.addClass('arrow');
                    a.append(arrow);
                    li.append(a);
                    var menus = $('<ul></ul>');
                    menus.addClass('sub-menu').css("display", "none");
                    init(menus, item.menus);
                    li.append(menus);
                }
                else {
                    var href = 'javascript:addTabs({id:\'' + item.id + '\',title: \'' + item.text + '\',close: true,url: \'' + item.url + '\'});';
                    a.attr('href', href);
                    //if (item.istab)
                    //  a.attr('href', href);
                    //else {
                    //  a.attr('href', item.url);
                    //  a.attr('title', item.text);
                    //  a.attr('target', '_blank')
                    //}
                    li.append(a);
                }
                target.append(li);
            });
        }
    }

    $.fn.sidebarMenu.defaults = {
        url: null,
        param: null,
        data: null
    };
})(jQuery);