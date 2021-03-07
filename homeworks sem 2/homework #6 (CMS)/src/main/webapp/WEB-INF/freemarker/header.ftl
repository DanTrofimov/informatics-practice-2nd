<#macro header pages>
    <header>
        <div class="info">
             <#if pages?has_content>
                <#list pages as page>
                    <a href="<@spring.url '/user${page.getRoute()}'/>">
                        ${page.getRoute()}
                    </a>
                </#list>
                 <#else >
                 no pages yet
             </#if>
        </div>
        <a href="<@spring.url "/admin"/>" class="edit-link">edit</a>
    </header>
</#macro>