var pageEdit = {
    data () {
        return {
        	edmPartLibrary: {
        		deviceName: '',
        		deviceCode: '',
        		model:'',
        		category:'',
        		type:'',
        		brand:'',
        		norm:'',
        		warehouse: '',
        		unit:'',
        		price: 0,
        		amount: 0,
        		warningValue: 3,
        		manufacturer:'',
        		supplier:'',
        		materialTypeName:'',
        		labelCode:'',
        		useLife:'',
        		warrantyPeriod:'',
        		scrappedTime:'',
        		buyTime:'',
        		remark:''
            },
            editRuleValidate: {
            	deviceName: [
                    { required: true, message: '备件名称不能为空', trigger: 'blur' }
                ],
                deviceCode: [
                    { required: true, message: '备件编码不能为空', trigger: 'blur' }
                ],
                warehouse: [
            		{ required: true, message: '存放位置不能为空', trigger: 'blur' }
            	],
                price: [
                	{ required: true, message: '价格不能为空', trigger: 'change',type:"number" }
            	],
            	amount: [
            		{ required: true, message: '数量不能为空', trigger: 'change',type:"number" }
        		],
            	warningValue: [
            		{ required: true, message: '预警值不能为空', trigger: 'change',type:"number"}
        		],
        		unit: [
	            	{ required: true, message: '单位不能为空', trigger: 'blur' }
            	]
            }
        }
    },
    mounted : function() {
		var s=this;
		var key=getQueryString(location.href,"key");
		if(key && key!= null && key!=''){
			axios.get('/eam/eam/eamPartLibrary/getEamPartLibrary?key='+key).then(response => {
				s.edmPartLibrary=Object.assign(s.edmPartLibrary,response.data);
			});
		}
	},
    methods: {
    	handleSubmit () {
    		this.$refs.editForm.validate((valid) => {
		        if (valid) {
		        	var s=this;
		        	s.$Spin.show();
//		        	var key=getQueryString(location.href,"key");
//		    		if(key && key!= null && key!=''){
//		    			s.edmPartLibrary.key=key;
//					}
		        	axios.post('/eam/eam/eamPartLibrary/saveEamPartLibrary',s.edmPartLibrary).then(response => {
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
var PageEdit = Vue.extend(pageEdit);
new PageEdit().$mount('#pageEdit');