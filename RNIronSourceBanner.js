import React from 'react';
import PropTypes from 'prop-types';
import {requireNativeComponent} from 'react-native';

const RNIronSourceBannerNative = requireNativeComponent('RNIronSourceBanner', null);

export default class RNIronSourceBannerComponent extends React.Component {

  static propTypes = {
    size: PropTypes.oneOf(['BANNER', 'LARGE', 'RECTANGLE', 'SMART']),
    onLoad: PropTypes.func,
    onError: PropTypes.func,
    onDismissScreen: PropTypes.func,
    onLeaveApplication: PropTypes.func,
    onWillPresentScreen: PropTypes.func,
    onClick: PropTypes.func,
    style: PropTypes.object,
  }

  static defaultProps = {
    size: 'BANNER',
  };

  onBannerEvent = ({nativeEvent}) => {
    if (this.props[nativeEvent.type]) {
      this.props[nativeEvent.type](nativeEvent.payload || {});
    }
  };

  // componentWillUnmount() {
    // RNIronSourceBannerNative.destroyBanner();
  // }

  render() {
    return (
      <RNIronSourceBannerNative size={this.props.size}
                                onBannerEvent={this.onBannerEvent}
                                style={this.props.style} />
    )
  }
}
