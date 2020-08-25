// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.ads.sdk.impl;

import android.os.RemoteException;

import androidx.annotation.Keep;

import com.ads.sdk.common.IAdFactory;
import com.ads.sdk.common.IAdControl;
import com.ads.sdk.common.dynamic.IObjectWrapper;
import com.ads.sdk.common.dynamic.ObjectWrapper;
import com.ads.sdk.impl.webview.AdWebView;

@Keep
public class AdFactoryImpl extends IAdFactory.Stub {
    @Override
    public IObjectWrapper loadAd(IAdControl control, IObjectWrapper context, String url) throws RemoteException {
        AdWebView webView = new AdWebView(ObjectWrapper.unwrap(context), control);
        webView.loadUrl(url);
        return ObjectWrapper.wrap(webView);
    }
}
