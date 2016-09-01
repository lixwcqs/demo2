/**
 * Created by li on 2015/10/24.
 */

var ctx = getContextPath();

function getContextPath(){
    var contextPath = document.location.pathname;
    var index =contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0,index+1);
    delete index;
    return contextPath;
}

function initUser(){
    $.jgrid.defaults.styleUI = 'Bootstrap';
    console.log(ctx+'/user/list2.action');
    $("#users").jqGrid({
        //提交表单的URL
        url: ctx+"/user/list2.action",
        //服务器返回的数据格式
        datatype: "json",
        editurl:'${ctx}/user/create.action',
        //提交方式
        mtype: "POST",
        //table的首行列名
        colNames:['用户名', '密码', '邮箱','Primary Key','创建日期'],
        //各列数据
        colModel:[
            {name:'name', label:'用户名',width:'20%',align:'center',editable:true,
                editoptions : {readonly : false,size : 10}
            },
            {name:'password', width:'15%',align:'center',hidden:true,editable:true,
                editrules : {readonly : true,size : 10, edithidden:true}
            },
            {name:'email',width:'20%', align:"center",editable:true},
            {name:'id', width:'1%', align:"left", sortable:false,key: true,editable:true,hidden:true},
            {name:'createDate', width:'35%', align:"left", sortable:false,editable:true}
        ],
        jsonReader: {
            root:"users",       // 对应于colModel
            total:'jqpage.pages',
            records: 'jqpage.totalCount',
            repeatitems: false
        },
        //数据
        edit:true,

        //显示翻页按钮，及当前页记录和总记录数
        viewrecords: true,
        styleUI : 'Bootstrap',
        rownumbers:true,//记录序号
        rowNum: 6,//grid显示记录条数
        rowList: [6,25,35],
        //表单高度
        height: 220,
        //宽
        width:1000,
        // 表下面的导航栏
        pager: "#gridPager",
        // 表信息
        caption: "联系人列表",
        //
        algin:'center',

        userDataOnFooter: true,
    });

    $('#users').navGrid('#gridPager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: true, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {
            editCaption: "The Edit Dialog",
            recreateForm: false,
            checkOnUpdate : true,
            checkOnSubmit : true,
            closeAfterEdit: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Add Dialog
        {
            closeAfterAdd: true,
            recreateForm: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Delete Dailog
        {
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        });
}


function tmp(){
    console.log('${ctx}/user/list2.action');
    $.jgrid.defaults.styleUI = 'Bootstrap';
    console.log('${ctx}/user/list2.action');
    $("#users").jqGrid({
        //提交表单的URL
        url: "${ctx}/user/list2.action",
        //服务器返回的数据格式
        datatype: "json",
        //提交方式
        mtype: "POST",
        //table的首行列名
//            colNames:['用户名', '密码', '邮箱','Primary Key','创建日期','更新日期'],
        //各列数据
        colModel:[
            {
                name:'name', label:'用户名',width:'20%',align:'center',editable:true,
                editoptions : {size : 10}
            },
            {
                name:'password', width:'15%',align:'center',hidden:false,editable:true,
                editrules : {readonly : true,size : 10, edithidden:true}
            },
            {
                name:'email',width:'20%', align:"center",editable:true,
                editrules:{
                    email:true,
                },
                editoptions:{

                }
            },
            {
                name:'id', width:'1%', align:"left", sortable:false,key: true,editable:true,hidden:true},
            {
                name:'createDate', width:'15%', align:"left", sortable:true,editable:false,
                editrules:{
                    readonly:true,
                }
            },
            {
                name:'updateDate',width:'15%',sortable:true,editable:true,
                editoptions: {
                    // dataInit is the client-side event that fires upon initializing the toolbar search field for a column
                    // use it to place a third party control to customize the toolbar
                    dataInit: function (element) {
                        $(element).datetimepicker({
                            autoclose:true,
                            format: 'yyyy-mm-dd',
                            orientation: 'bottom',
                            todayBtn:'true',
//                               //国际化
                            language:"zh-CN"
                        });
                    }
                }
            },
            {
                name:'操作',width:'15%',sortable:true,editable:true,
                formatter: 'checkbox2'
            }
        ],
        //显示checkbox,可进行批量操作
        multiselect: true,
        jsonReader: {
            root:"users",       // 对应于colModel
            total:'jqpage.pages',
            records: 'jqpage.totalCount',
            repeatitems: false
        },
        //数据
        edit:true,

        //显示翻页按钮，及当前页记录和总记录数
        viewrecords: true,
        styleUI : 'Bootstrap',
        rownumbers:true,//记录序号
        rowNum: 6,//grid显示记录条数
        rowList: [6,25,35],
        //表单高度
        height: 220,
        //宽
        width:1000,
        // 表下面的导航栏
        pager: "#gridPager",
        // 表信息
        caption: "联系人列表",
        //
        sortable:true,
        sortname: 'id',
        sortorder : 'desc',
    });

    $('#users').navGrid('#gridPager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: true, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {
            url: "${ctx}/user/update.action",
            editCaption: "编辑",
            recreateForm: true,
            checkOnUpdate : true,
            checkOnSubmit : true,
            closeAfterEdit: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Add Dialog
        {
            url: "${ctx}/user/create.action",
            closeAfterAdd: true,
            recreateForm: false,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Delete Dailog
        {
            url: "${ctx}/user/delete.action",
            errorTextFormat: function (data) {
//                        return 'Error: ' + data.responseText
                return '请选择要删除的数据'
            }
        });
}