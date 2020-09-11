package ch.teko.railtraffic;

import org.controlsfx.control.PopOver;

import javafx.scene.web.WebView;

public class OwnPopOver extends PopOver {

	public OwnPopOver() {
		this.setArrowLocation(PopOver.ArrowLocation.LEFT_CENTER);
		this.setCornerRadius(4);
		this.setTitle("Traffic Details");
		this.setAutoHide(true);
	}

	public void SetContentPopOver(TrafficDatasetFields fields) {
		WebView webview = new WebView();
		webview.setPrefWidth(500);
		webview.setPrefHeight(300);
		webview.getEngine().loadContent(fields.getDescription_html());
		this.setContentNode(webview);
	}
}
