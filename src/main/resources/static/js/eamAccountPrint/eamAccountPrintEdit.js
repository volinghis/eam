var pageEdit = {
        data () {
            return {
            	editModel: {
            		deviceNum: '',
            		deviceName: '',
            		factoryName:'',
            		installLocation:'',
            		purchaseTime:'',
            		buyingPrice:0,
            		deviceStatus:''
                },
                editRuleValidate: {
                	deviceName: [
                        { required: true, message: '设备名称不能为空', trigger: 'blur' }
                    ],
                    deviceNum: [
                        { required: true, message: '设备编号不能为空', trigger: 'blur' }
                    ],
                    purchaseTime: [
                        { required: true, type: 'date', message: '请选择采购日期', trigger: 'change' }
                    ]
                }
            }
        },
        mounted : function() {
			var self=this;
			var key=getQueryString(location.href,"key");
			if(key&&key!=null&&key!=''){
				axios.get('/eam/eam/eamAccountPrint/getAccountPrintInfo?key='+key).then(response => {
					self.editModel=Object.assign(self.editModel,response.data);
				});
			}

		},
        methods: {
            handleSubmit () {
			      this.$refs.editForm.validate((valid) => {
				        if (valid) {
				        	var self=this;
				        	self.$Spin.show();
				        	console.log(this.editModel);
				        	axios.post('/eam/eam/eamAccountPrint/saveEamAccountPrint',this.editModel).then(response => {
				        		   if(response.data.resultType=='ok'){
				        			   console.log(response.data);
				          			   parent.eamAccountPrintPage.flushData();
				          			   this.$Message.success({content:response.data.message,onClose:function(){
		        						   GPageModel.close();
		        					   }});
				        		   }else{
				        			   this.$Message.error({content:response.data.message});
				        		   }
			    			}).catch(function(error){
			    				
			    			}).then(function () {
			    				self.$Spin.hide();
			    			});
				        	   
				        }
				      })
    
            },
            handleReset () {
                this.$refs['editForm'].resetFields();
            }
        }
    }
var PageEdit = Vue.extend(pageEdit)
new PageEdit().$mount('#pageEdit')