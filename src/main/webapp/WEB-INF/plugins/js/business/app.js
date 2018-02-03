/**
 * Created by Saul on 11/18/16.
 */
define(["../common_metronic", "cus"], function (p) {
    require(["menu-sidebar", "quick-nav", "quick-sidebar", "LG", "layout", "bootstrap_tab_close"], function (a) {
        $("#maingrid").ligerGrid({
            columns: [
                {display: '主键', name: 'CustomerID', align: 'left', width: 120},
                {display: '公司名', name: 'CompanyName', minWidth: 60, align: 'left'},
                {display: '联系名', name: 'ContactName', width: 120, align: 'left'},
                {display: '城市', name: 'City', heightAlign: 'center'},
                {display: '电话', name: 'Phone', width: 170, align: 'left'},
                {display: '传真', name: 'Fax', width: 170, align: 'left'}
            ], data: $.extend(true, {}, CustomersData), pageSize: 30,
            toolbar: {
                items: [{text: '高级自定义查询', click: null, icon: 'search2'}]
            },
            title: "测试表2格显示",
            width: '90%', height: '100%', checkbox: false
        });

        $('#menu2').sidebarMenu({
            data: [{
                id: '1',
                text: '基础系统设置',
                icon: 'icon-wrench',
                url: '',
                menus: [{
                    id: '11',
                    text: '设备管理',
                    icon: 'icon-energy',
                    url: './test'
                }, {
                    id: '12',
                    text: '物业管理',
                    icon: 'icon-home',
                    url: '',
                    menus: [{
                        id: '121',
                        text: '物业维护',
                        icon: 'icon-vector',
                        url: './test'
                    }, {
                        id: '122',
                        text: '物业设备维护',
                        icon: 'icon-directions',
                        url: './test'
                    }]
                }]
            }, {
                id: '2',
                text: '用户管理',
                icon: 'icon-users',
                url: '',
                menus: [{
                    id: '21',
                    text: '用户列表',
                    icon: 'icon-glass',
                    url: '/BasicData/BasicFeature/Index'
                }, {
                    id: '22',
                    text: '用户车牌',
                    icon: 'icon-glass',
                    url: '/BasicData/Features/Index'
                }, {
                    id: '23',
                    text: '用户钱包',
                    icon: 'icon-glass',
                    url: '/Model/Index'
                }, {
                    id: '24',
                    text: '用户停车状态',
                    icon: 'icon-glass',
                    url: '/Station/Index'
                }]
            }]
        });
    });
});
function addTabs(gotoUrl) {
    $("#mainPage").empty();
    var item = {'id': gotoUrl.id, 'name': gotoUrl.title, 'url': gotoUrl.url, 'closable': true};
    closableTab.addTab(item);
}