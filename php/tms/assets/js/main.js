var siteUrl = 'tms.test'
function  submitTask(){

    $('#submit').on('click',function(e){
        e.preventDefault();
        
        let data  =  new FormData();
        data.append('task_name',$('#task_name').val())
        data.append('deadline',$('#deadline').val())
        data.append('status',$('#status').val())
        data.append('assigned_to',$('#assigned_to').val())
        axios.post('/app.php',data).then((res)=>{
            console.log(res)
        })

        return false;
    })


}


submitTask();
