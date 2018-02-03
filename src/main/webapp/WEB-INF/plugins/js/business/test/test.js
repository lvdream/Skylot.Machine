/**
 * Created by Saul on 11/18/16.
 */
define(["../../common_metronic", "../cus"], function (p) {
    require(["layout", "ligerui", "jquery-validation", "jquery-validation-metadata", "jquery-validation-message", "LG"], function (a) {
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
            width: '98%', height: '100%', checkbox: false
        });
    });
});

