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

function initBook(){
    $.jgrid.defaults.styleUI = 'Bootstrap';
    console.log(ctx+'/book/list.action');
    $("#books").jqGrid({
        //提交表单的URL
        url: ctx+"/book/list.action",
        //服务器返回的数据格式
        datatype: "json",
        editurl:'${ctx}/book/create.action',
        //提交方式
        mtype: "POST",
        //table的首行列名
        //各列数据
        colModel:[
            {name:'name', label:'书名',width:'20%',align:'center',editable:true,
                formoptions: { rowpos: 1, colpos: 1 },
                editoptions : {readonly : false,size : 10},
            },
            {name:'price',label:'定价', width:'15%',align:'center',hidden:true,editable:true,
                editrules : {readonly : true,size : 10, edithidden:true},
                formoptions: { rowpos: 1, colpos: 2 }
            },
            {
                name:'selling',label:'售价',width:'20%', align:"center",editable:true,
                formoptions: { rowpos: 2, colpos: 1 }
            },

            {name:'author', label:'作者',width:'20%',align:'center',editable:true,
                editoptions : {readonly : false,size : 10},
                formoptions: { rowpos: 2, colpos: 2 }
            },
            {name:'publisher', label:'出版社',width:'20%',align:'center',editable:true,
                editoptions : {readonly : false,size : 10},

            },
            {name:'publishDate', label:'出版日期',width:'20%',align:'center',editable:true,
                editoptions : {readonly : true,size : 10,
                    dataInit: function(element) {
                        $(element).datetimepicker({
                            format: "yyyy/mm/dd",
                            autoclose: true,
                            todayBtn: true,//是否显示今日按钮
                            startDate: "2013-02-14 10:00",//日历最高的时间
                            //此数值被当做步进值用于构建小时视图。对于每个 minuteStep 都会生成一组预设时间（分钟）用于选择。
                            //minuteStep: 10,
                            hidden:true,//是否直接弹出时间控件
                            //参考http://www.bootcss.com/p/bootstrap-datetimepicker/的【选项】说明
                            startView:2,//2 or 'month' for month view (the default)
                            minView:2,
                            maxView:2,
                            language:"zh-CN"
                        });
                    }
                },
                formatter: 'date', formatoptions: { srcformat: 'l, F d, Y', newformat: 'd/m/Y'}
            },
            {name:'id', width:'1%', align:"left", sortable:false,key: true,editable:false,hidden:true},
            {name:'createDate', label:'创建日期',width:'35%', align:"left", hidden:true},
            {name:'updateDate', label:'更新日期',width:'35%', align:"left", hidden:true},
        ],
        jsonReader: {
            root:"books",       // 对应于colModel
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
        caption: "书籍列表",
        //
        algin:'center',

        userDataOnFooter: true,
    });



    $('#books').navGrid('#gridPager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: true, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {

            top :50,  //位置
            left: 200, //位置
            //height:480, //大小
            width:880, //大小

            editCaption: "编辑",
            recreateForm: false,
            checkOnUpdate : true,
            checkOnSubmit : true,
            closeAfterEdit: true,
            url:ctx+"/book/update.action",
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Add Dialog
        {
            top :50,  //位置
            left: 200, //位置
            //height:580, //大小
            width:880, //宽度
            closeAfterAdd: true,
            recreateForm: true,

            url:ctx+"/book/create.action",
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Delete Dailog
        {
            url:ctx+"/book/delete.action",
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        });
}

function searchBook(){
    var name = jQuery("#name").val()||"";
    jQuery("#books").jqGrid('setGridParam', {
        url: getContextPath()+"/book/list.action?name="+name,
        mtype: 'POST',
        page : 1
    }).trigger("reloadGrid");
}