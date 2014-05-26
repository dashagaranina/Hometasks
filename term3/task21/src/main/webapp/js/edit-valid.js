$(document).ready(function(){

    $("#editform").validate({
        
       rules:{

            fio:{
                required: true,
                minlength: 16,
                maxlength: 40
            },

           group:{
               required: true,
               digits: true,
               minlength: 3,
               maxlength: 7
           },
            
            date:{
                required: true,
                date: true
            },
           lab: {
               required: true,
               minlength: 3,
               maxlength: 10
           } ,

           activity: {
               required: true,
               maxlength: 60
           }
       },
       
       messages:{
        
            fio:{
                required: "Это поле обязательно для заполнения",
                minlength: "Фамилия, Имя и Отчество должен состоять минимум из 16 символов",
               maxlength: "Максимальное число символов - 40"
            },

           date:{
               required: "Это поле обязательно для заполнения",
               minlength: "Дата должна состоять из 10 символов",
               maxlength: "Дата должна состоять из 10 символов"
           },
            
            group:{
                required: "Это поле обязательно для заполнения",
                minlength: "Номер группы должен состоять минимум из 3 символов",
                maxlength: "Номер группы должен состоять максимум из 7 символов"
            },
           lab:{
               required: "Это поле обязательно для заполнения",
               minlength: "Название лаборатории должно содердать минимум 3 символа",
               maxlength: "Максимальное число символов - 40"
           },
           activity:{
               required: "Это поле обязательно для заполнение",
               maxlength: "Максимальное число символов - 40"
           }
       }
    });
}); //end of ready