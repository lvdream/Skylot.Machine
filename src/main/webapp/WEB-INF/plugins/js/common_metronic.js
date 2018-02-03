/**
 * Created by Saul on 11/18/16.
 */
var messages_bundle_js;
require.config({
    baseUrl: "../plugins-js/",
    urlArgs: "r=" + (new Date()).getTime(),
    map: {
        '*': {
            'css': 'css.min'
        }
    },
    paths: {
        "jquery": "jquery/jquery.1.12.min",
        "bootstrap": "metronic/bootstrap/bootstrap.min",
        "bootstrap_tab_close": "metronic/bootstrap/bootstrap-closable-tab",
        "js-cookie": "metronic/js.cookie.min",
        "jquery-slimscroll": "metronic/jquery-slimscroll/jquery.slimscroll.min",
        "jquery.blockui": "metronic/jquery.blockui.min",
        "bootstrap-switch": "metronic/bootstrap/bootstrap-switch/js/bootstrap-switch.min",
        "metronic-app": "metronic/app.min",
        "layout": "metronic/layout.min",
        "quick-nav": "metronic/quick-nav.min",
        "quick-sidebar": "metronic/quick-sidebar.min",
        "menu-sidebar": "metronic/menu",
        "ligerui": "ligerUI/js/ligerui.all",
        "json2": "json2",
        "jquery-validation": "jquery-validation/jquery.validate.min",
        "jquery-validation-metadata": "jquery-validation/jquery.metadata",
        "jquery-validation-message": "jquery-validation/messages_cn",
        "LG": "LG",
        "jquery-form": "jquery.form",
        // "cus": "../message_resource_bundle",
    },
    waitSeconds: 0,
    shim: {
        "bootstrap": {
            deps: ["jquery"]
        },
        "js-cookie": {
            deps: ["jquery"]
        }, "menu-sidebar": {
            deps: ["jquery"]
        },
        "jquery-slimscroll": {
            deps: ["jquery"]
        },
        "jquery.blockui": {
            deps: ["jquery"]
        },
        "bootstrap-switch": {
            deps: ["jquery", "bootstrap"]
        }, "bootstrap_tab_close": {
            deps: ["bootstrap"]
        },
        "metronic-app": {
            deps: ["js-cookie", "jquery-slimscroll", "jquery.blockui", "bootstrap-switch", "css!../plugins-css/metronic/google.css", "css!../plugins-css/metronic/font-awesome/css/font-awesome.css", "css!../plugins-css/metronic/simple-line-icons/simple-line-icons.min", "css!../plugins-css/metronic/bootstrap/css/bootstrap.min", "css!../plugins-css/metronic/bootstrap/bootstrap-switch/css/bootstrap-switch.min", "css!../plugins-css/metronic/components.min", "css!../plugins-css/metronic/plugins.min", "css!../plugins-css/metronic/layout.min", "css!../plugins-css/metronic/custom.min"]
        },
        "layout": {
            deps: ["metronic-app"]
        },
        "menu-sidebar": {
            deps: ["layout"]
        },
        "quick-nav": {
            deps: ["layout"]
        },
        "quick-sidebar": {
            deps: ["quick-nav"]
        },
        "ligerui": {
            deps: ["jquery", "css!../plugins-css/ligerUI/skins/Aqua/css/ligerui-all.css", "css!../plugins-css/ligerUI/skins/ligerui-icons.css"]
        },
        "LG": {
            deps: ["jquery-form", "ligerui"]
        },
        "jquery-validation": {
            deps: ["LG"]
        }, "jquery-validation-metadata": {
            deps: ["LG"]
        }, "jquery-validation-message": {
            deps: ["LG"]
        }
    }
});