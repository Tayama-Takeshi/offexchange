
public class OffexchangeInfo {

	//銘柄コード
    private String securitiesCode;
    //銘柄名
    private String securitiesName;
    //価格
    private String price;
    //数量
    private String quantity;
    //約定日時
    private String tradeDateTime ;

	public String getSecuritiesCode() {
		return securitiesCode;
	}
	public void setSecuritiesCode(String securitiesCode) {
		this.securitiesCode = securitiesCode;
	}
	public String getSecuritiesName() {
		return securitiesName;
	}
	public void setSecuritiesName(String securitiesName) {
		this.securitiesName = securitiesName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTradeDateTime() {
		return tradeDateTime;
	}
	public void setTradeDateTime(String tradeDateTime) {
		this.tradeDateTime = tradeDateTime;
	}



}
