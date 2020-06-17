import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import CustomerApiService  from "../services/RestApiService";

class MakeTrade extends Component {
	constructor(props) {
		super(props);

		this.state = {

            client: '',
            orderType: '',
            price: '',
            quantity: '',
            stock:''
            
            
		};

		this.update = this.update.bind(this);

		this.displayLogin = this.displayLogin.bind(this);
	}

	update(e) {
		let name = e.target.name;
		let value = e.target.value;
		this.setState({
			[name]: value
		});
	}
	displayLogin(e) {
		e.preventDefault();
		console.log('You have successfully ordered');
		console.log(this.state);
		this.setState({
            client: '',
            orderType: '',
            price: '',
            quantity: '',
            stock:''
		});
	}



	render() {
		return (
			<div className="maketrade">
				<form onSubmit={this.displayLogin}>
					<h2>Make Trade</h2>

					<div className="client">
						<input
							type="text"
							placeholder="client Name"
							name="client"
							value={this.state.client}
							onChange={this.update}
						/>
					</div>

					<div className="ordertype">
						<input
							type="text"
							placeholder="ordertype"
							name="ordertype"
							value={this.state.ordertype}
							onChange={this.update}
						/>
					</div>

					<div className="price">
						<input
							type="text"
							placeholder="price"
							name="price"
							value={this.state.price}
							onChange={this.update}
						/>
					</div>
                    <div className="quantity">
						<input
							type="text"
							placeholder="quantity"
							name="quantity"
							value={this.state.quantity}
							onChange={this.update}
						/>
					</div>
                    <div className="stock">
						<input
							type="text"
							placeholder="stock"
							name="stock"
							value={this.state.stock}
							onChange={this.update}
						/>
					</div>

					

					<button onClick={() => {new CustomerApiService().addOrder(
                            {client: this.state.client,
                            ordertype: this.state.ordertype, 
                            price: this.state.price,
                            quantity:this.state.quantity,
                            stock:this.state.stock})}
                            }>Place Order</button>
				</form>
				<br></br>
				{/* <Link to="/">Login Here</Link> */}
			</div>
		);
	}
}

export default MakeTrade;
