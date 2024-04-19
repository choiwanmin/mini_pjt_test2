package page;

import java.util.ArrayList;

public class GeneralPage<t> {
	public ArrayList<ArrayList<t>> paging(ArrayList<t> list,int temp){
		int cnt=0;
		ArrayList<ArrayList<t>> page=new ArrayList<>();
		while(cnt<list.size()) {
			ArrayList<t> p=new ArrayList<>();
			int i=0;
			while(i<temp && cnt+i<list.size()) {
				p.add(list.get(i+cnt));
				i++;
			}
			cnt=cnt+temp;
			page.add(p);
		}
		return  page;
	}
}
