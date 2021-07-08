//hàm xét Regex là controtor function
function  Validate(options) {
    //hàm thực hiện validate
    function validate1(inputElement, rule) {
        var errorMessage = rule.test(inputElement.value);
        var erroElement =inputElement.parentElement.querySelector('.form-message');

        if(errorMessage)
        {
            erroElement.innerText =errorMessage;
            inputElement.parentElement.classList.add('invalid');
        }
        else {
            erroElement.innerText =' ';
            inputElement.parentElement.classList.remove('invalid');
        }
    }
    // Lấy element của form cần validate
    var formElement = document.querySelector(options.form);
  //  console.log(options.rules)
    if(formElement)
    {
        options.rules.forEach(function (rule) {
           var inputElement = formElement.querySelector(rule.selector);
            // var erroElement =inputElement.parentElement.querySelector('.form-message');
           if(inputElement)
           {
               // xử lý trường hợponblur khi di chuyển chuột ra khỏi input
               inputElement.onblur= function () {
                   validate1(inputElement,rule);
               }
           //     xử lý trường hợp  oninput mỗi khi người nhập vào input
               inputElement.oninput = function () {
                   var erroElement =inputElement.parentElement.querySelector('.form-message');
                   erroElement.innerText =' ';
                   inputElement.parentElement.classList.remove('invalid');
               }
           }
        });
    }
}
//định nghĩa các rules
// nguyên tác của các rules
// 1. khi có lỗi trả lại message lỗi
//2. khi ko có lỗi không trả lại gì cả(undefined)
//value.trim()  loại bỏ khoảng cách 2 bên đầu chuỗi
Validate.isID = function (selector) {
    // return ra op zec gồm 2  key 1 là selector và 2 là test
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined:'Vui lòng nhập trường này'
        }
    };
}

Validate.isTen = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            var TEN = /^[A-Z][A-Za-z0-9]*/;
            return TEN.test(value) ? undefined:'Vui long nhập tên chữ cái hoa đầu tiên';
        }
    };
}
Validate.isNgay = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            var NGAY = /(0[1-9]|[12][0-9]|3[01])[ \.-](0[1-9]|1[012])[ \.-](19|20|)\d\d/;
            return NGAY.test(value)? undefined : 'Vui lòng nhập đúng định dang DD-MM-YYYY';
        }
    };
}

Validate.isSCMND= function (selector) {
    return {
        selector: selector,
        test:function (value) {
            var CMND = /([0-9]{9})|([0-9]{12})/;
            return  CMND.test(value)? undefined : 'Vui lòng nhập số cmnd có 9 hoặc 12 số';
        }
    };
}



Validate.isEmail = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            var email = /[A-Za-z0-9]*[@]{1}[A-Za-z0-9]*[.]com/;
            // return value.trim() ? undefined:'Vui lòng nhập trường này'
            return  email.test(value) ? undefined : 'Vui lòng nhập đúng định dang của email';
        }
    };
}

Validate.isID_NV = function (selector) {
    return{
        selector: selector,
        test:function (value) {
            var  ID_NV = /NV-[0-9]{2}/;
            return ID_NV.test(value)? undefined :'Vui lòng nhập lại đúng định dạng Mã nv  là NV-XX trong đó X là số 0 ->9';
        }
    }
}
Validate.isSDT = function (selector) {
    return{
        selector: selector,
        test:function (value) {
            var SDT = /090[0-9]{7}|091[0-9]{7}|[(]84[)][+]90[0-9]{7}|[(]84[)][+]91[0-9]{7}/;
            return SDT.test(value) ? undefined :'Vui long nhập đúng định dạng số đt';
        }
    }
}
Validate.isLuong = function (selector) {
    return{
        selector:selector,
        test:function (value) {
             var LUONG = /([1-9]{1}[0-9]*[.][0-9]*)|([1-9]{1}[0-9]*)/;
            return LUONG.test(value)? undefined :'Vui lòng nhập số dương';
        }
    }
}


Validate.isDiaChi = function (selector) {
    // return ra op zec gồm 2  key 1 là selector và 2 là test
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined:'Vui lòng nhập trường này';
        }
    };
}
    Validate.isTrinhDo= function (selector) {
        // return ra op zec gồm 2  key 1 là selector và 2 là test
        return {
            selector: selector,
            test: function (value) {
                return value.trim() ? undefined:'Vui lòng nhập trường này';
            }
        };
    }
    Validate.isViTri= function (selector) {
        // return ra op zec gồm 2  key 1 là selector và 2 là test
        return {
            selector: selector,
            test: function (value) {
                return value.trim() ? undefined:'Vui lòng nhập trường này';
            }
        };
    }
    Validate.isUser= function (selector) {
        // return ra op zec gồm 2  key 1 là selector và 2 là test
        return {
            selector: selector,
            test: function (value) {
                return value.trim() ? undefined:'Vui lòng nhập trường này';
            }
        };
    }
Validate.isGioitinh= function (selector) {
    return{
        selector:selector,
        test :function (value) {
            var GIOITINH = /(nam)|(nu)|(thuba)]/;
            return GIOITINH.test(value)? undefined :'Vui lòng nhập đúng định dạng';
        }
    }
}

Validate.isID_KH = function (selector) {
    return{
        selector: selector,
        test:function (value) {
            var  ID_NV = /KH-[0-9]{2}/;
            return ID_NV.test(value)? undefined :'Vui lòng nhập lại đúng định dạng Mã nv  là NV-XX trong đó X là số 0 ->9';
        }
    }
}