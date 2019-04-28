import React from 'react';

class SearchFilter extends React.Component{
    render() {
        return (
            <div className="filter">
                <span>{this.props.name}</span>
                {this.state.filters.date.dropdown ? <div className="filter-drop grey-text">
                    <div className="filter-drop-elem">Новые</div>
                    <div className="filter-drop-elem">Старые</div>
                </div> : ""}
            </div>
        );
    }
}

export default SearchFilter;