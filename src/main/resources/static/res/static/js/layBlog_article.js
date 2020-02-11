layui.define(['element', 'carousel', 'laypage', 'form', 'laytpl'], function (exports) {
    var $ = layui.jquery
        , laytpl = layui.laytpl
        , element = layui.element
        , carousel = layui.carousel
        , laypage = layui.laypage
        , form = layui.form;
    var myCount;
    var channel = $("li.channel.layui-this").val();
    $.ajax({
        type: 'post',
        data: {channel: channel},
        url: '/myCountPage',
        async: false,
        success: function (data) {
            myCount = data.page;
        }
    });
    laypage.render({
        elem: 'myContent_page'
        , count: myCount //数据总数
        , limit: 5
        , limits: [5, 10, 15, 20, 25]
        , jump: function (obj) {
            $.ajax(
                {
                    url: '/pagination',
                    data: {curr: obj.curr, channel: channel},
                    dataType: 'json',
                    type: 'post',
                    success: function (data) {
                        var myContents = [];
                        $("#MyContents").empty();
                        layui.each(data, function (index, item) {
                            myContents.push('<div class=\"item\"> ' +
                                '<div class=\"item-content\">\n' +
                                '            <h3>\n' +
                                '              <em class=\"Subtitle\">' + item.title + '</em>\n' +
                                '            </h3>\n' +
                                '          <br/>\n' +
                                '            <p id=\"myContent.id\" style=\"display: none;\">' + item.id + '</p>\n' +
                                '            <pre>' + item.content + '</pre>\n' +
                                '      </div>\n' +
                                '      <div class=\"date-box\">\n' +
                                '          <div class=\"date\" style=\"color: white;\">\n' +
                                '              <span>' + item.time + '</span>\n' +
                                '               <span  class=\"layui-btn-group\">\n' +
                                '\t\t\t\t\t\t<button type=\"button\" onclick="del_btn(&quot;' + item.id + '&quot;)"\n' +
                                '                                class=\"layui-btn layui-btn-xs layui-btn-danger\">删除</button>\n' +
                                '\t\t\t\t\t\t<button type=\"button\" onclick="update_btn(&quot;' + item.id + '&quot;)"\n' +
                                '                                class=\"layui-btn layui-btn-xs layui-btn-normal\">修改</button>\n' +
                                '</span>\n' +
                                '           </div>\n' +
                                '\n' +
                                '        </div>' +
                                '</div>');
                        });
                        myContents.join('');
                        $("#MyContents").append(myContents);

                    }
                }
            )

        }
    });
    exports('layBlog_article', {});


});


