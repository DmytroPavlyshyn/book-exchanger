    
import React, { Component } from 'react';
import ExpenceItem from './ExpenceItem';

class ExpenceList extends Component {
      
    constructor() {
        super();
        console.log("[ExpenceList] constructor");
        this.state = {
            items:[]
        };
    }

    componentDidMount() {
        console.log("[ExpenceList] componentDidMount");
        let initialItems = [];
        fetch('http://localhost:8080/api/announce')
            .then(response => {
                return response.json();
                
            }).then(data => {
                initialItems = data.map((planet) => {
                console.log(planet)
                return planet
            });

            this.setState({
                items: initialItems,
            });
        });
    }
    
    componentWillUnmount() {
        console.log("[ExpenceList] componentWillUnmount");
    }

    render() {
        console.log("[ExpenceList] render");

         

        return (
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User</th>
                        <th>Book</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                {
                    this.state.items.map(item => <ExpenceItem item={ item } />)
                    
                }
                </tbody>
            </table>
        );
    }
}

export default ExpenceList;