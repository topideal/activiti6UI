/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.app.service.runtime;

import org.activiti.app.domain.runtime.RelatedContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmittedFormVariables {

    private Map<String, List<RelatedContent>> variableContent;
    private Map<String, Object> variables;

    public Map<String, List<RelatedContent>> getVariableContent() {
        return variableContent;
    }
    public void setVariableContent(Map<String, List<RelatedContent>> variableContent) {
        this.variableContent = variableContent;
    }
    public Map<String, Object> getVariables() {
        return variables;
    }
    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public void addContent(String variableName, RelatedContent content) {
        if (variableContent == null) {
            variableContent = new HashMap<String, List<RelatedContent>>();
        }
        List<RelatedContent> contentList = variableContent.get(variableName);
        if (contentList == null) {
            contentList = new ArrayList<RelatedContent>();
            variableContent.put(variableName, contentList);
        }

        // allow forms to have empty content lists.
        if (content != null) {
            contentList.add(content);
        }

    }

    public boolean hasContent() {
        if (variableContent != null) {
            return !variableContent.isEmpty();
        }
        return false;
    }
}
