import React, { Component } from 'react';

class AnnouncePublishForm extends Component
{

    constructor() {
        super();
    
        this.state = {
            name: '',
            author: '',
            genre: '',
            year: '',
            description: ''
        };
    
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);

        console.log("[AnnouncePublishForm] constructor");
    }


  componentDidMount() {
    console.log("[AnnouncePublishForm] componentDidMount");
  }

  componentWillUnmount() {
    console.log("[AnnouncePublishForm] componentWillUnmount");
  }

  handleChange(e) {
    let target = e.target;
    let value = target.value;
    let name = target.name;

    this.setState({
      [name]: value
    });
  }

  onSubmit(e) {
    e.preventDefault();

    console.log('The form was submitted with the following data:');
    console.log(this.state);

    fetch("http://localhost:8080/api/announce/add", {
      method: "POST",
      headers: {
        "content-type": "application/json"
      },
      body: JSON.stringify(this.state)
    });
  }

  render() {
    return (
      <div className="App">
  
        <div>
          <form onSubmit={this.onSubmit}>
            <div className="FormField">
                  <label className="FormField__Label" htmlFor="name">Name</label>
                  <input type="text" id="name" className="FormField__Input" placeholder="Enter name of the book" name="name" value={this.state.name} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="FormField__Label" htmlFor="author">Author</label>
                  <input type="text" id="author" className="FormField__Input" placeholder="Enter author of the book" name="author" value={this.state.author} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="FormField__Label" htmlFor="genre">Genre</label>
                  <input type="text" id="genre" className="FormField__Input" placeholder="Enter genre of the book" name="genre" value={this.state.genre} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="FormField__Label" htmlFor="year">Year</label>
                  <input type="text" id="year" className="FormField__Input" placeholder="Enter the year of publishment" name="year" value={this.state.year} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="FormField__Label" htmlFor="description">Description</label>
                  <input type="text" id="description" className="FormField__Input" placeholder="Enter description of the book" name="description" value={this.state.description} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <button className="FormField__Button mr-20">Publish</button>
              </div>
          </form>
        </div>  
  
      </div>
    );
  }
}

export default AnnouncePublishForm;


// import React, { Component } from 'react';
// import ReactSearchBox from 'react-search-box'

// export default class AnnouncePublish extends Component {
//   constructor() {
//     super();
//     console.log("[ExpenceList] constructor");
//     this.state = {
      
//     // this.handleChange = this.handleChange.bind(this);
//     // this.onSubmit = this.onSubmit.bind(this);
//     // this.handleInputChange = this.handleInputChange.bind(this);
//     }
//   }


//   componentDidMount() {
//     console.log("[AnnouncePublish] componentDidMount");

//     let req =  () => fetch('http://localhost:8080/api/announce/')
//       .then(response => {
//         return response.json();

//       }).then(data1 => {
//         console.log("[AnnouncePublish] - setState")
//         this.setState({data:data1.map((item) => {
//           let state = {
//             key: item.id,
//             value:item.bookName
//           };
//           return state;
//         })});
//       })
//       req();
//       this.render();
//   }


//   componentWillUnmount() {
//     console.log("[RegistrationForm] componentWillUnmount");
//   }

//   // handleChange(e) {
//   //   let target = e.target;
//   //   let value = target.value;
//   //   let name = target.name;

//   //   this.setState({
//   //     [name]: value
//   //   });
//   // }

//   // handleInputChange = () => {
//   //   this.setState({
//   //     data: this.data
//   //   })

//     // this.setState((state, props) =>{
//       // return {
//         //  data: this.data
//       // }
//     //  });
//   //   console.log(this.data)
//   //   console.log("yep")
//   // }

  
//   // onSubmit(e) {
//   //   e.preventDefault();

//   //   console.log('The form was submitted with the following data:');
//   //   console.log(this.state);

//   //   fetch("http://localhost:8080/api/book", {
//   //     method: "POST",
//   //     headers: {
//   //       "content-type": "application/json"
//   //     },
//   //     body: JSON.stringify(this.state)
//   //   });
//   // }

//   render() {
//     console.log("[Announce Publish] - render",this.state.data)
//     return (
//       <ReactSearchBox
//         placeholder="Placeholder"
//         value=""
//         data={this.state.data}
//         callback={record => console.log(record)}
//         // onChange={this.handleInputChange}
//       />
//     )
//   }
// }
// }
