
if (!React) 
	React = require('react');




var Name = React.createClass({
  render: function() {
    return (
      <div>Hello {this.props.name}!</div>
    );
  }
});



var Test = React.createClass({
  getDefaultProps: function(){
	  return {server: false}
  },
  render: function() {
    return (
      <div>
      	Rendered from: {this.props.server ? 'server' : 'client'}
      	<Name name="horst"/>
      </div>
      
    );
  }
});

if (module)
	module.exports = Test;
