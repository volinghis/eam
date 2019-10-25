var partLibraryList = new Vue({
    data () {
        return {
        	tableMaxHeight:200,
        	 single: true,
        	 queryBean:{
        		 query:'',
        		 page:1,
        		 size:20,
        		 totalCount:0,
        		 dataList:[]
        	 },
        	 initQueryBean:{},
        	 listColumns: [
                 {
                     type: 'index',
                     width: 60,
                     align: 'center'
                 },
                 {
                     title: '备件编号',
                     key: 'deviceCode',
                     align: 'center'
                 },
                 {
                     title: '备件名称',
                     key: 'deviceName',
                     align: 'center'
                 },
                 {
                     title: '备件型号',
                     key: 'model',
                     align: 'center'
                 },
                 {
                     title: '备件类型',
                     key: 'type',
                     align: 'center'
                 },
                 {
                     title: '品牌',
                     key: 'brand',
                     align: 'center'
                 },
                 {
                     title: '规格',
                     key: 'norm',
                     align: 'center'
                 },
                 {
                     title: '所在仓库',
                     key: 'Warehouse',
                     align: 'center'
                 },
                 {
                     title: '单位',
                     key: 'unit',
                     align: 'center'
                 },
                 {
                     title: '价格',
                     key: 'price',
                     align: 'center'
                 },
                 {
                     title: '数量',
                     key: 'amount',
                     align: 'center'
                 },
                 {
                     title: '库存预警值',
                     key: 'warningValue',
                     align: 'center'
                 },
                 {
                     title: '操作',
                     key: 'action',
                     width: 150,
                     align: 'center',
                     render: (h, params) => {
                         return h('div', [
                             h('Button', {
                                 props: {
                                     type: 'primary',
                                     size: 'small'
                                 },
                                 style: {
                                     marginRight: '5px'
                                 },
                                 on: {
                                     click: () => {
                                         this.show( params.row.key)
                                     }
                                 }
                             }, '编辑'),
                             h('Button', {
                                 props: {
                                     type: 'error',
                                     size: 'small'
                                 },
                                 on: {
                                     click: () => {
                                         this.remove(params.row.key)
                                     }
                                 }
                             }, '删除')
                         ]);
                     }
                 }
             ]
        }
    },
	mounted : function() {
		this.initQueryBean=Object.assign(this.initQueryBean,this.queryBean);
		this.tableMaxHeight=window.top.indexFrame.getFrameHeight()-this.$refs.buttons.offsetHeight-document.querySelector(".ivu-page").offsetHeight;
		this.flushData();
	},
    methods: {
    	changePage:function(pageNum){
   		 	this.queryBean.page=pageNum;
   		 	this.flushData();
   	 },
   	 doSearch:function(v){
   		 this.queryBean.query=v;
   		 this.flushData();
   	 },
   	 flushData:function(){
		var _this=this;
			_this.queryBean.totalCount=0;
			_this.queryBean.dataList=[];
			axios.post('/eam/eam/eamPartLibrary/getEamPartLibraryList',_this.queryBean).then(response => {
				_this.queryBean.totalCount=response.data.totalCount;
				_this.queryBean.dataList=response.data.dataList;
				
			});
    	},
        show(index) {
        	var c={title:'编辑备件',url:'/eam/html/eamPartLibrary/eamPartLibraryEdit.html?key='+index};
        	GPageModel.info(c);
        },
        add:function(){
       	 	var c={title:'新增备件',url:'/eam/html/eamPartLibrary/eamPartLibraryEdit.html',height:500,width:700};
       	 	GPageModel.info(c);
    	},
        remove:function(index) {
    		this.$Modal.confirm({
					title:'',
					content:'删除后数据将无法恢复，是否继续？',
					onOk:function(){
						var _this=this;
						_this.$Spin.show();
		    			axios.get('/org/orgUser/deleteOrgUser?key='+index).then(response => {
		    				   if(response.data.resultType=='ok'){
		    					   partLibraryList.flushData();
		    					   this.$Message.success({content:response.data.message,onClose:function(){
		    						   
		    					   }});
		    					   
			        		   }else{
			        			   this.$Message.error({content:response.data.message});
			        		   }
		    			}).catch(function(error){
		    				
		    			}).then(function () {
		    				_this.$Spin.hide();
		    			});
					}
				});

        }
    },
	el:'#partLibraryList'
});
