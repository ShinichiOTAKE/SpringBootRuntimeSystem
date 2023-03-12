import React from "react";
import { Outlet } from "react-router-dom";

export const Root = () => {
    return (
      <>
        <nav>
          <div className="navigation">
            <div className="title-bar">
              <ul>
                <li>販売管理</li>
                <li>画面ID:9999999999</li>
                <li>23/3/10 13:36</li>
                <li>9876:システム部</li>
                <li>岡谷太郎</li>
              </ul>
            </div>
            <div className="menu-bar">
              <ul>
                <li><a href="/menu">メニュー</a></li>
                <li><a href="/smp00010">サンプル</a></li>
              </ul>
            </div>
          </div>
        </nav>
        <div id="screen" className = "screen"><Outlet /></div>
      </>
    );
}