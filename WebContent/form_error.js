/**
 *
 */



//例

//function subForm() {
//  //変数の定義
//  var pattern = /^[a-zA-Z0-9_+-]+(\.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\.)+[a-zA-Z]{2,}$/;
//  var account = document.getElementById("accId").value;
//  var password = document.getElementById("pswId").value;
//  var gender = document.getElementsByName("gender");
//  var favorite = document.getElementsByName("favorite");
//  var address = document.getElementById("address").value;
//  var isRight = true;
//
//  //メールアドレス項目のチェック
//  if(pattern.test(account)) {
//    document.getElementById("spId1").innerHTML = "";
//  } else {
//    document.getElementById("spId1").innerHTML = "※メールアドレスの形式で入力してください。";
//    isRight = false;
//  }
//  //パスポート項目のチェック
//  if(password.length <= 5) {
//      document.getElementById("spId2").innerHTML = "※半角英数字5文字以上で入力してください";
//      isRight = false;
//  } else {
//    document.getElementById("spId2").innerHTML = "";
//  }
//  //性別項目のチェック
//  var male = gender[0];
//  var female = gender[1];
//  if (male.checked || female.checked) {
//    document.getElementById("spId3").innerHTML = "";
//  } else {
//    document.getElementById("spId3").innerHTML = "※性別を選択してください";
//    isRight = false;
//  }
//  //趣味項目のチェック
//  var checkedSize = 0;
//  for(var i = 0; i < favorite.length; i++) {
//    if(favorite[i].checked) {
//      checkedSize ++ ;
//    }
//  }
//  if (checkedSize > 0) {
//    document.getElementById("spId4").innerHTML = "";
//  } else {
//    document.getElementById("spId4").innerHTML = "※趣味をチェックしてください";
//    isRight = false;
//  }
//  //住所項目のチェック
//  if(address.length <= 0) {
//    document.getElementById("spId5").innerHTML = "※住所を入力してください";
//    isRight = false;
//  } else {
//    document.getElementById("spId5").innerHTML = "";
//  }
//  return isRight;
//}







function stu_form() {
	  //変数の定義
	  var ent_year = document.getElementsById("ent_year");
	  var class_num = document.getElementById("class_num").value;
	  var isRight = true;





//	入学年度が未入力で、クラスが入力済み

	  System.out.println("papapapapapapapp");
	  System.out.println(ent_year);
	  System.out.println(class_num);

	  if(ent_year.length <= 0 && class_num.length >= 0){
		    document.getElementById("opop").innerHTML = "クラスを指定する場合は入学年度も指定してください";
		    isRight = false;
		  } else {
		    document.getElementById("opop").innerHTML = "";
		  }

	  System.out.println(isRight);
	  System.out.println("papapapapapapapp");
	  return isRight;
	}