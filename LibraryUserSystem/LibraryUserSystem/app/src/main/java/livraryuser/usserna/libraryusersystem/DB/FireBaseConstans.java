package livraryuser.usserna.libraryusersystem.DB;

public class FireBaseConstans {

   public final static String PAR_USER = "USER";
   public final static String PAR_BOOKS ="Books";
   public final static String B_LIST = "대여목록";
   public final static String ch_ID = "ID";
   public  final static String PASSWORD = "Password";
   public final static String AUTHOR = "저자";
   public final static String BOOK_NAME = "책 이름";
   public final static String PUBLICSHER = "출판사";
    public final static String BARCORD = "바코드";
    public final static String RENTALCHECK = "대여여부";
    public final static String PRICE = "가격";
   private static String userName;

   /*
        구조

        Books
        ㄴ111111(바코드)
           ㄴ책 이름
           ㄴ 출판사
           ㄴ 저자
           ㄴ 바코드
           ㄴ 가격
           ㄴ 대여여부
       USER
       ㄴ irispon(아이디)
          ㄴ id
          ㄴ password
          ㄴ 대여목록
             ㄴ 바코드
             ㄴ 바코드



    */


   public static void setUserName(String userId){

       userName = userId;

   }
    public static String getUserName(){

       return  userName;

    }

}
