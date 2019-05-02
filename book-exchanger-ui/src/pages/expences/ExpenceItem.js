import React, { Component } from 'react';


class ExpenceItem extends Component {

    constructor() {
        super();
        console.log("[ExpenceItem] constructor");
    }

    componentDidMount() {
        console.log("[ExpenceItem] componentDidMount");
    }
    
    componentWillUnmount() {
        console.log("[ExpenceItem] componentWillUnmount");
    }

    render() {
        console.log("[ExpenceItem] render");        

        const item = this.props.item;
        return (
            <tr key={ item.id }>
                <td>{ item.id }</td>
                <td>{ item.user }</td>
                <td>{ item.book }</td>
                <td>{ item.announceTimestamp }</td>
            </tr>
        );
    }
}

export default ExpenceItem;