package livraryuser.usserna.libraryusersystem.Search.Custom_Search_list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import livraryuser.usserna.libraryusersystem.R;

public class SearchAdater extends BaseAdapter  implements Filterable {

    /* 아이템을 세트로 담기 위한 어레이 */
    Filter listFilter ;
    private ArrayList<SearchItem> mItems = new ArrayList<>();
    private ArrayList<SearchItem> filteredItemList  = mItems ;

    @Override
    public int getCount() {
        return filteredItemList.size();
    }

    @Override
    public SearchItem getItem(int position) {
        return filteredItemList.get(position);
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
            convertView = inflater.inflate(R.layout.book_list_custom, parent, false);
        }



        TextView book_name = (TextView) convertView.findViewById(R.id.book_name) ;
        TextView book_author = (TextView) convertView.findViewById(R.id.book_author) ;
        TextView book_publisher = (TextView) convertView.findViewById(R.id.book_publisher) ;
        TextView book_barcord = (TextView) convertView.findViewById(R.id.book_barcod) ;
        TextView book_price = (TextView) convertView.findViewById(R.id.book_price) ;
        TextView book_rentalcheck = (TextView) convertView.findViewById(R.id.book_reantal_chek) ;
        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        SearchItem myItem = filteredItemList.get(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        book_name.setText(myItem.getName());
        book_author.setText(myItem.getauthor());
        book_publisher.setText(myItem.getpublisher());
        book_barcord.setText(myItem.getabarcod());
        book_price.setText(myItem.getPrice());
        book_rentalcheck.setText(myItem.getrental_Check());
        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */


        return convertView;
    }


    public void addItem(SearchItem myItem) {

        mItems.add(myItem);

    }

    @Override
    public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new ListFilter() ;
        }

        return listFilter ;
    }




    private class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults() ;

            if (constraint == null || constraint.length() == 0) {
                results.values = mItems ;
                results.count = mItems.size() ;
            } else {
                ArrayList<SearchItem> itemList = new ArrayList<SearchItem>() ;

                for (SearchItem item : mItems) {
                    if (item.getName().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemList.add(item) ;
                        Log.e("체크 아이템","ㅇㅇㅇ");
                    }
                }

                results.values = itemList ;
                results.count = itemList.size() ;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            // update listview by filtered data list.
            filteredItemList = (ArrayList<SearchItem>) results.values ;

            // notify
            if (results.count > 0) {
                notifyDataSetChanged() ;
            } else {
                notifyDataSetInvalidated() ;
            }
        }
    }



}