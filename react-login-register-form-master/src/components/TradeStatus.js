import React, {Component} from 'react'
import CustomerApiService  from "../services/RestApiService";
class TradeStatus extends Component{

	
	constructor(props){
		super(props);
		
		this.state = {
			
			trades: [],
			result:''
			
		}
		
		
		this.getAllTrades = this.getAllTrades.bind(this);
		
		
	}
		
	componentDidMount(){
		
		this.getAllTrades();
	}
	
	
	getAllTrades(){
				
		CustomerApiService.getTrades()
							.then( res => {
								
								this.setState({trades: res.data})
								
							}
		
			)	
		}
	
	
	render(){
		
		return (
		
		
		<div>
		
			<table border="1">
			
			
			  <thead>
				
				<th> Trade ID </th>
				<th> Buyer </th>
				<th> Price </th>
                <th> Quantity</th>
                <th> Seller </th>
                <th> Stock </th>
                <th> Timestamp </th>
			  
			  </thead>
			  
			  <tbody>
			  
			  {
				  
				this.state.trades.map(
					trade =>
					
						<tr key={trade.id}>
						
						
							<td> {trade.id} </td>
							<td> {trade.buyer} </td>
							<td> {trade.price} </td>
                            <td> {trade.quantity} </td>
                            <td> {trade.seller} </td>
                            <td> {trade.stock} </td>
                            <td> {trade.time_stamp} </td>
						
						</tr>
					
									  
				 ) 
			  }
				
			  
			  </tbody>
			
			
			</table>
		
		
		</div>
		
		
		
	   )
		
		
	}
	
	


}

export default TradeStatus;