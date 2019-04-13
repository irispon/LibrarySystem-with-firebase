package livraryuser.usserna.libraryusersystem.Rental_list.Custom_Rental_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import livraryuser.usserna.libraryusersystem.R;

public class Rental_List_Adater extends BaseAdapter{

    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<Rental_List_Item> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Rental_List_Item getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rental_list_custom, parent, false);
        }



        TextView book_name = (TextView) convertView.findViewById(R.id.book_name) ;
        TextView book_author = (TextView) convertView.findViewById(R.id.book_author) ;
        TextView book_publisher = (TextView) convertView.findViewById(R.id.book_publisher) ;
        TextView book_barcord = (TextView) convertView.findViewById(R.id.book_barcod) ;
        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        Rental_List_Item myItem = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        book_name.setText(myItem.getName());
        book_author.setText(myItem.getauthor());
        book_publisher.setText(myItem.getpublisher());
        book_barcord.setText(myItem.getabarcod());
        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */


        return convertView;
    }

    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(String book_name, String book_author, String book_publisher,String book_barcord) {

        Rental_List_Item mItem = new Rental_List_Item();

        /* MyItem에 아이템을 setting한다. */
        mItem.setName(book_name);
        mItem.setauthor(book_author);
        mItem.setpublisher(book_publisher);
        mItem.setbarcod(book_barcord);
        /* mItems에 MyItem을 추가한다. */
        mItems.add(mItem);

    }

    public void addItem(Rental_List_Item myItem) {

        mItems.add(myItem);

    }
}