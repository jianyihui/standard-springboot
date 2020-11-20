<div>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <style>/* Reset style */
        td {
            line-height: 24px;
        }
    </style>
    <style media="only screen and (max-width: 640px)">/* Mobile styles */
        @media only screen and (max-width: 640px) {
            .qmbox table.email-container {
                width: 100% !important;
                border-radius: 0 !important;
            }
        }</style>
    <table style="width:100%;background-color: #f4f6f9;" class="container">
        <tbody>
        <tr>
            <td></td>
            <td style="width:640px;">
                <table style="width:100%;margin:10px auto;background:#fff;border-radius: 6px;overflow: hidden;box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);"
                       cellpadding="0" cellspacing="0" class="email-container">
                    <tbody style="
    border-radius: 10px;
">
                    <tr class="email-title">
                        <td style="position:relative;height: 56px;text-align:center;color: #fff;background: #1867c0;">
                            <div style="position: absolute;left:10px;top:12px;line-height: 30px;vertical-align: middle">
                                <i><a style="color:#f4f6f9;text-decoration: none" href="https://www.docszz.com" target="_blank">${(params.systemName)!""}</a></i>
                            </div>

                            <div class="email-title">
                                <div style="font-size: 20px;line-height:1.2;margin:10px 0;" class="title">${(params.messageHead)!""}</div>
                            </div>
                        </td>
                    </tr>
                    <tr class="email-body">
                        <td style="padding:10px 20px;">
                            <table style="width:100%;margin-bottom:10px;" class="email-body-item">
                                <tbody>
                                <tr>
                                    <td style="font-size: 14px;">
                                        <div style="color:#212121;padding:5px 0;" class="content">
                                            您好：
                                        </div>
                                        <div style="color: #414141;padding:5px 0;text-indent: 2em;" class="content">
                                            如果您并没有访问过${(params.systemName)!""}，或没有进行上述操作，请忽略这封邮件。您不需要退订或进行其他进一步的操作。
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div style="border-radius:8px;font-size:52px;font-weight:700;line-height:80px;text-indent:14px;letter-spacing:16px;background: #eee;width:240px;height:80px;text-align: center;margin:10px auto;">
                                            ${(params.origin)!""}
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <table style="width:100%;" class="email-body-item">
                                <tbody>
                                <tr class="email-footer">
                                    <td style="color:#999;font-size:14px;padding:20px 0;" class="email-meta">
                                        <div style="border-top:1px solid #eeeff2;padding-top:30px;" class="email-extra">
                                            如果不知道为什么收到该邮件，请不要做任何操作。<br><br>感谢您的访问，祝您使用愉快！
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table style="width:100%;padding-bottom:30px;margin:-10px auto 0;border-collapse:separate;"
                       cellpadding="0" cellspacing="0" class="email-footer">
                    <tbody>
                    <tr>
                        <td style="color:#999;font-size:14px;padding:5px 30px;text-align:right;"><a
                                    href="https://www.docszz.com" target="_blank" style="color:#999;text-decoration:none;"
                                    class="light-grey" rel="noopener">${(params.systemName)!""} © 2020</a></td>
                    </tr>
                    </tbody>
                </table>
            </td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
