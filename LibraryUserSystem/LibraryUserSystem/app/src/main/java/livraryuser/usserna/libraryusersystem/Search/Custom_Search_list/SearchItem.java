package livraryuser.usserna.libraryusersystem.Search.Custom_Search_list;


public class SearchItem {


    private String name;
    private String author;
    private String publisher;
    private String barcod;
    private String rental_Check;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name ="책 이름:\n"+name;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author ="저자: \n"+author;
    }

    public String getabarcod() {
        return barcod;
    }

    public void setbarcod(String barcod) {
        this.barcod ="바코드: \n"+barcod;
    }
    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher ="출판사:\n "+publisher;
    }

    public String getrental_Check() {
        if(rental_Check.equals("true")){

            return  "대여여부:\n"+"대여O";
        }
        else{

            return "대여여부:\n"+"대여X";
        }

    }

    public void setrental_Check(String rental_Check) {
        this.rental_Check =rental_Check;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price ="가격: \n"+price;
    }
}