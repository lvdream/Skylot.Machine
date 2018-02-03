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
        "jquery": "jquery/jquery-1.9.0.min",
        "ligerui": "ligerUI/js/ligerui.min",
        "json2": "json2",
        "jquery-validation": "jquery-validation/jquery.validate.min",
        "jquery-validation-metadata": "jquery-validation/jquery.metadata",
        "jquery-validation-message": "jquery-validation/messages_cn",
        "LG": "LG",
        "jquery-form": "jquery.form",
        "message_bundle": "../message_resource_bundle",
        // "cus": "../message_resource_bundle",
    },
    waitSeconds: 0,
    shim: {
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
        },

    }
});