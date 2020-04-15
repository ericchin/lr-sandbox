import React from 'react';
import {AlloyEditor} from 'alloyeditor';

class CustomButton extends React.Component {
	static defaultProps = {
		command: 'youtube'
	};

	static key = 'youtube';

	render() {
		const cssClass = 'ae-button ae-icon-tabs';
		const svg = Liferay.Util.getLexiconIconTpl('video');

		return (
			<button
				className={cssClass}
				onClick={this.execCommand}
				dangerouslySetInnerHTML={ {__html: svg} }
			/>
		);
	}
}

export default AlloyEditor.Base.ButtonCommand(CustomButton);