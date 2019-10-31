	
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
                    fixed: 'left',
                    width: 60,
                    align: 'center'
                },
                {
                    title: '设备编号',
                    fixed: 'left',
                    width: 150,
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
                                	strokeColor:['#ed4014','#19be6b'],
                                	textInside:true,
                                	strokeWidth:18
                                }
                            });
                    }
                    	
                },
                {
                    title: '设备名称',
                    width: 150,
                    key: 'deviceName'
                },
                {
                    title: '生产厂家',
                    width: 150,
                    key: 'factoryName',
                    tooltip:true
                },
                {
                	title: '供应商',
                	width: 150,
                	key: 'supplier',
                	tooltip:true
                },
                {
                    title: '安装位置',
                    width: 150,
                    key: 'installLocation'
                },
                {
                	title: '启用日期',
                	width: 120,
                	key: 'runDate'
                },
                {
                    title: '采购时间',
                    width: 120,
                    key: 'purchaseTime'
                },
                {
                	title: '保修期',
                	width: 80,
                	key: 'warranty'
                },
                {
                	title: '检修频率',
                	width: 100,
                	key: 'repairFrequency'
                },
                {
                	title: '采购价格',
                	width: 100,
                	key: 'buyingPrice'
                },
                {
                	title: '使用寿命',
                	width: 100,
                	key: 'serviceLife'
                },
                {
                	title: '负责人',
                	width: 150,
                	key: 'person'
                },
                {
                	title: '设备状态',
                	width:100,
                	align:'center',
                	key: 'deviceStatus',
                	render: (h, params) => {
                		 var s = params.row.deviceStatus; 
                		 var status,text;
                		 switch(s){
                		   case 'normal':
                			   text='正常';
                           	   status='success';
                           break;
                		   case 'error':
                			   text='故障';
                			   status='error';
                			   break;
                		   case 'maintenance':
                			   text='保养';
                			   status='warning';
                			   break;
                		   case 'idle':
                			   text='闲置';
                			   status='processing';
                			   break;
                		 }
                         return h('Tooltip',{
                        	 props:{ 
                        		 content:text,
                        		 theme:'light',
                        		 placement:'right'
                        	 }},[h('Badge',{
                        	 props:{
                        		 status:status
                        	 }
                        	 })]);
                    }
                },
                {
                	title: '备注',
                	width: 150,
                	key: 'remarks'
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 150,
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
                            }, '完善资料'),
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
        	var c={title:'新增设备台账',url:'/eam/html/eamAccountPrint/eamAccountPrintAdd.html',height:120};
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