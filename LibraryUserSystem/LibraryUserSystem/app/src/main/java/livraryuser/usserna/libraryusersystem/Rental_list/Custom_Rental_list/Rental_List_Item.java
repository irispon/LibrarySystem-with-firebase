package livraryuser.usserna.libraryusersystem.Rental_list.Custom_Rental_list;


public class Rental_List_Item {


    private String name;
    private String author;
    private String publisher;
    private String barcod;


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
        this.author ="저자:\n" +author;
    }

    public String getabarcod() {
        return barcod;
    }

    public void setbarcod(String barcod) {
        this.barcod ="바코드:\n" +barcod;
    }
    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = "출판사:\n"+ publisher;
    }
}