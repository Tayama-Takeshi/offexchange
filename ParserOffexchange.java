import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserOffexchange {

	public static void main(String[] args) throws IOException,JsonProcessingException  {
		// TODO 自動生成されたメソッド・スタブ

		Document document = Jsoup.connect("http://info.offexchange2.jp/offexchange/servlet/FindLatestExecutionServlet").data("transactionTime", "083000-235959").get();

		Elements elements = document.select("#main table.list tbody tr");

		ArrayList<OffexchangeInfo> infoArray = new ArrayList<OffexchangeInfo>();

		for (Element element : elements) {
			int td_cnt = 0;

			OffexchangeInfo infos = new OffexchangeInfo();

			Elements td_elements = element.select("td");
			for (Element td_element : td_elements) {

				switch (td_cnt) {
				case 0:{
					//System.out.println("銘柄コード:"+td_element.text());

					infos.setSecuritiesCode(td_element.text());
					break;
				}
				case 1:{
					//System.out.println("銘柄名:"+td_element.text());
					infos.setSecuritiesName(td_element.text());
				    break;
				}
				case 2:{
					//System.out.println("価格:"+td_element.text());
					infos.setPrice(td_element.text());
				    break;
				}
				case 3:{
					//System.out.println("数量:"+td_element.text());
					infos.setQuantity(td_element.text());
				    break;
				}
				case 4:{
					//System.out.println("約定日時:"+td_element.text());
					infos.setTradeDateTime(td_element.text());
				    break;
				}
				default:
				    // 式の値がどのcaseの値とも一致しなかったときの処理
				}

				td_cnt++;
			}

			infoArray.add(infos);

//			ObjectMapper mapper = new ObjectMapper();
//	        String json = mapper.writeValueAsString(hoge);
//
//	        System.out.println(json);

			//System.out.println(infos.toString());
        }


		 ObjectMapper mapper = new ObjectMapper();
		 try {
				String json = mapper.writeValueAsString(infoArray);
				System.out.println(json);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		//System.out.println(infoArray);

	}

}
