var pageEdit = {
    data () {
        return {
        	formInline: {
        		deviceName: '',
        		deviceCode: '',
        		Warehouse:'',
        		price:'',
        		amount:'',
        		warningValue:''
            },
            editRuleValidate: {
            	deviceName: [
                    { required: true, message: '备件名称不能为空', trigger: 'blur' }
                ],
                deviceCode: [
                    { required: true, message: '备件编码不能为空', trigger: 'blur' }
                ],
            	Warehouse: [
            		{ required: true, message: '存放位置不能为空', trigger: 'blur' }
            	],
                price: [
                	{ required: true, message: '价格不能为空', trigger: 'blur' }
            	],
            	amount: [
            		{ required: true, message: '数量不能为空', trigger: 'blur' }
        		],
            	warningValue: [
            		{ required: true, message: '预警值不能为空', trigger: 'blur' }
        		]
            }
        }
    },
    mounted : function() {
		var s=this;
		var key=getQueryString(location.href,"key");
		if(key&&key!=null&&key!=''){
			axios.get('/org/orgUser/getOrgUser?key='+key).then(response => {
				s.formInline=Object.assign(s.formInline,response.data);
			});
		}
	},
    methods: {
//        handleSubmit () {
//        	this.$refs.editForm.validate((valid) => {
//        		if (valid) {
//		        	var self=this;
//		        	self.$Spin.show();
////		         	var orgKey=getQueryString(location.href,"orgKey");
////		        	if(orgKey&&orgKey!=null&&orgKey!=''){
////						self.formInline.orgKey=orgKey;
////					}
//		        	axios.post('/eam/eamPartLibrary/saveEamPartLibrary',self.formInline).then(response => {
//	        		   if(response.data.resultType=='ok'){
//	        			   parent.partLibraryList.flushData();
//	        			   this.$Message.success({content:response.data.message,onClose:function(){
//    						   GPageModel.close();
//    					   }});
//	        		   }else{
//	        			   this.$Message.error({content:response.data.message});
//	        		   }
//	    			}).catch(function(error){
//	    				
//	    			}).then(function () {
//	    				self.$Spin.hide();
//	    			});
//		        }
//			})
//		},
    	handleSubmit () {
    		this.$refs.editForm.validate((valid) => {
		        if (valid) {
		        	var s=this;
		        	s.$Spin.show();
		        	axios.post('/eam/eam/eamPartLibrary/saveEamPartLibrary',s.formInline).then(response => {
	        		   if(response.data.resultType=='ok'){
	          			   parent.partLibraryList.flushData();
	          			   this.$Message.success({content:response.data.message,onClose:function(){
    						   GPageModel.close();
    					   }});
	        		   }else{
	        			   this.$Message.error({content:response.data.message});
	        		   }
	    			}).catch(function(error){
	    				
	    			}).then(function () {
	    				s.$Spin.hide();
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