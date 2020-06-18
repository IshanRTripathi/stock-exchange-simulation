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
		
			
		<div classname="content-page" >
{/* 
style={{backgroundImage:"url('https://www.fnordware.com/superpng/pnggrad16rgb.png')", 
		backgroundPosition: 'center',backgroundSize: 'cover',backgroundRepeat: 'no-repeat',height:"500px",width:"100%"}} */}

			
			<h1>Confirmed Trades</h1>
		

			
		
			<table border ="1">
			
			
			  <thead>
				
				<th> Trade ID </th>
				<th> Buyer </th>
				<th> Price </th>
                <th> Quantity</th>
                <th> Seller </th>
                <th> Stock </th>
                {/* <th> Timestamp </th> */}
			  
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
                            {/* <td> {trade.timestamp} </td> */}
						
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