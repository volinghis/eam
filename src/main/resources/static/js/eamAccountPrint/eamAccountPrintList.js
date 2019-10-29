	
var eamAccountPrintPage=new Vue({
    data () {
        return {
        	 tableMaxHeight:200,
        	 queryBean:{
        		 query:'',
        		 page:1,
        		 size:20
        	 },
        	initQueryBean:{},
        	listColumns: [
                {
                    type: 'index',
                    width: 60,
                    align: 'center'
                },
                {
                    title: '设备编号',
                    key: 'deviceNum'
                },
                {
                    title: '资料完善度',
                    width:200,
                    align:'center',
                    key: 'completePoint',
                    render: (h, params) => {
                        return h('i-progress', {
                                props: {
                                	percent: params.row.completePoint,
                                	strokeColor:['#2d8cf0','#19be6b'],
                                	textInside:true,
                                	strokeWidth:20
                                }
                            });
                    }
                    	
                },
                {
                    title: '设备名称',
                    key: 'deviceName'
                },
                {
                    title: '生产厂家',
                    key: 'factoryName',
                    tooltip:true
                },
                {
                    title: '安装位置',
                    key: 'installLocation'
                },
                {
                    title: '采购时间',
                    key: 'purchaseTime'
                },
                {
                	title: '采购价格',
                	key: 'buyingPrice'
                },
                {
                	title: '设备状态',
                	key: 'deviceStatus',
                	render: (h, params) => {
                		 var status = params.row.deviceStatus; 
                		 var color,text;
                         if (status==='normal'){ 
                        	text='正常';
                        	color='success';
                         };
                         if (status==='error'){ 
                        	 text='故障';
                        	 color='error';
                         };
                         if (status==='maintenance'){ 
                        	 text='保养';
                        	 color='warning';
                         };
                         if (status==='idle'){ 
                        	 text='闲置';
                        	 color='primary';
                         };
                         return h('Tag', {
                             props: {
                                 type: 'dot',
                                 color: color
                             }
                         }, text);
                    }
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 160,
                    fixed: 'right',
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
            ],
        	 totalCount:0,
    		 dataList:[]
        }
    },
		mounted : function() {
			this.initQueryBean=Object.assign(this.initQueryBean,this.queryBean);
			this.tableMaxHeight=window.top.indexFrame.getFrameHeight()-this.$refs.addButton.offsetHeight-document.querySelector(".ivu-page").offsetHeight;
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
			axios.post('/eam/eam/eamAccountPrint/getEamAccountPrintList',_this.queryBean).then(response => {
				_this.totalCount=response.data.totalCount;
				_this.dataList=response.data.dataList;
			});
    	},
        show (index) {
        	var c={title:'编辑设备台账',url:'/eam/html/eamAccountPrint/eamAccountPrintEdit.html?key='+index,height:500,width:800};
        	GPageModel.info(c);
        },
        add:function(){
        	var c={title:'新增设备台账',url:'/eam/html/eamAccountPrint/eamAccountPrintEdit.html',height:500,width:800};
        	GPageModel.info(c);
        },
        exportData () {
                this.$refs.table.exportCsv({
                    filename: '设备台账',
                    original: false
                });
        }, 
        remove:function(index) {
    		this.$Modal.confirm({
					title:'',
					content:'删除后数据将无法恢复，是否继续？',
					onOk:function(){
						var self=this;
						self.$Spin.show();
		    			axios.get('/eam/eam/eamAccountPrint/deleteAccountPrintInfo?key='+index).then(response => {
		    				   if(response.data.resultType=='ok'){
		    					   eamAccountPrintPage.flushData();
		    					   this.$Message.success({content:response.data.message,onClose:function(){
		    						   
		    					   }});
		    					   
			        		   }else{
			        			   this.$Message.error({content:response.data.message});
			        		   }
		    			}).catch(function(error){
		    				
		    			}).then(function () {
		    				self.$Spin.hide();
		    			});
					}
				});

        }
    },
	el:'#eamAccountPrintList'
});