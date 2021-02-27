<#macro htmlHeader title description>
    <div>
        hello, I'm header component ${title}
        ${ springMacroRequestContext.contextPath }
        <p>${ description }</p>
    </div>
</#macro>