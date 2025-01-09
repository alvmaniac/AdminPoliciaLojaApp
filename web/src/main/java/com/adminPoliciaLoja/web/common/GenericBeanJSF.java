package com.adminPoliciaLoja.web.common;

import java.util.HashMap;
import java.util.Map;

//import javax.annotation.PostConstruct;
//import javax.enterprise.context.control.RequestContextController;
//import javax.faces.component.UIComponent;
//import javax.faces.event.ActionEvent;

//import org.primefaces.component.api.UIData;
//import org.primefaces.model.CollectionDataModel;

//import com.sun.jdi.InterfaceType;

public abstract class GenericBeanJSF<Entity, I> {

	/**
	 * Constantes para serem usadas como chave (nome) a ser armazenado no pageFlowScope o resultado
	 * das consultas.
	 */	
	public static final String SEARCH_RESULT = "searchResult";
	public static final String SEARCH_PARAMETERS = "searchParameters";
	public static final String ENTITY = "entity";
	
	/**
	 * Estados para ajudar os componentes a saberem em que estado estб o fluxo.
	 */
	public static final String STATE_EDIT = "edit";
	public static final String STATE_INSERT = "insert";
	public static final String STATE_DELETE = "delete";
	public static final String STATE_VIEW = "view";	
	public static final String STATE_SEARCH = "search";
	
	protected static final Map<String, String> titles = new HashMap<String, String>();
	static {
		titles.put(null, "Consultar"); // primeiro acesso a pбgina
		titles.put(STATE_SEARCH, "Consultar");
		titles.put(STATE_INSERT, "Inserir");
		titles.put(STATE_EDIT, "Editar");
		titles.put(STATE_VIEW, "Visualizar");
		titles.put(STATE_DELETE, "Excluir");
	}
	
	/**
	 * Painel de Ediзгo
	 */	
//	private UIComponent pnlEditing;
	
	/**
	 * Id do componente que exibe os dados. Nesta implementaзгo й esperada uma tabela, mas
	 * as subclasses podem alterar.
	 */
//	private  UIData tblData;
	
	/**
	 * Mensagem para quando o usuбrio nгo escolher nenhum item.
	 */
	protected String noItemSelectedMessage = "NNão item selecionado.";
	/**
	 * Mensagem para quando a busca nгo retornar nenhum resultado.
	 */
	protected String noResultMessage = "Nгo foram encontrados registros com esse critйrio.";
	/**
	 * Entidade usada para as operaзхes de editar, excluir, inserir.
	 * Os componentes de ediзгo farгo referкncia a esse objeto.
	 * 
	
	private Entity entity; */
		
	/**
	 * Objeto que armazena os parвmetros da busca. Usada em uma busca
	 * do tipo "findByExample".
	
	private Entity searchObject; */
	
	/**
	 * Interface com a camada de negуcios.
	 */
//	private Class<I> interfaz;
	
//	protected GenericBeanJSF(Class< I> interfaz) {
//		this();
//		this.interfaz = interfaz;
//	}
	
//	@SuppressWarnings("unchecked")
//	public GenericBeanJSF() {
//		super();
//	}
	
//	@PostConstruct
//	public void postConstruct() {
//		try {
//			// inicia a entidade com uma instвncia vazia.
//			if (getEntity() == null) {
//				setEntity(getNewEntityInstance());
//			}
//			if (getSearchObject() == null) {
//				setSearchObject(getNewEntityInstance());
//			}
//		} catch (Exception e) {
//			System.out.println("Os objetos nгo puderam ser instanciados corretamente.");
//			//nгo relanзa a exceзгo porque esses objetos podem ser informados atravйs de propriedades.
//		}		
//	}
//	
//	@SuppressWarnings("unchecked")
//	protected Entity getNewEntityInstance(){
//		try {
//			return (Entity) ((Class) ((java.lang.reflect.ParameterizedType) this
//					.getClass().getGenericSuperclass())
//					.getActualTypeArguments()[0]).newInstance();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return null;
//		}
//	}
//		
//	/**
//	 * Processa a inicializaзгo dos dados
//	 */
//	public void init(){
//		setCurrentState(null);
//		setSearchResult(null);
//		setEntity(getNewEntityInstance());
//		setSearchObject(getNewEntityInstance());	
//	}
//	/**
//	 * Evento que dispara a inicializaзгo. Pode ser usado por um ActionSource (botгo, link, menu ou similar) para inicar a implementaзгo de um
//	 * caso de uso que faзa parte da hierarquia dessa classe.
//	 * @param event
//	 */
//	public void init(ActionEvent event){
//		init();
//	}
//	/**
//	 * Implementa a aзгo de consulta. Disparado por um evento (actionListener) do UIXCommandButton (<tr:commandButton/>).
//	 * @param event Objeto que represento o evento.
//	 */
//	public void search(ActionEvent event) {
//		if (tblData != null) {
//
//			CollectionModel result = new PagingCollectionModel(tblData.getRows(), service, getSearchObject());
//			setSearchResult(result);
//
//			tblData.setRendered(result.getRowCount() > 0);
//			if (this.isSearching())
//				result.setSortCriteria(this.getDefaultSortCriteria());
////			tblData.setSortCriteria(this.getDefaultSortCriteria());
//
//			if (result.getRowCount() <= 0) {
//				FacesContext.getCurrentInstance().addMessage(
//						null,
//						new FacesMessage(FacesMessage.SEVERITY_WARN,noResultMessage, null));
//			}
//			setCurrentState(STATE_SEARCH);
//		}
//	}
//
//	/**
//	 * Salva os dados da alteraзгo / inclusгo.
//	 * @param event
//	 */
//	public void insert(ActionEvent event) {
//		// inclusгo
//		setEntity(service.insert(getEntity()));
//
//		FacesContext.getCurrentInstance().addMessage(null,
//				new FacesMessage("Item incluido com sucesso."));
//
//		// refaz a busca e volta para o estado de consultar
//		search(event);
//	}
//	
//	/**
//	 * Salva os dados da alteraзгo / inclusгo.
//	 * @param event
//	 */
//	public void update(ActionEvent event){
//		//update
//		setEntity(service.update(getEntity()));		
//
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item alterado com sucesso."));
//		//Obtйm o objeto de consulta previamente armazenado
//		//searchObject = (Entity) requestContext.getPageFlowScope().get(SEARCH_PARAMETERS);
//		//refaz a busca e volta para o estado de consultar
//		search(event);
//	}
//	
//	
//	/**
//	 * Realiza a aзгo que prepara a pбgina para a ediзгo dos dados
//	 * @param event
//	 */
//	public void prepareUpdate(ActionEvent event){
//		
//		if (this.getSelectedRowEntity() != null) {
//			setEntity(getSelectedRowEntity());
//
//			/*salva os dados da pesquisa, digitados pelo usuбrio para posteriormente
//			restaurar quando voltar para a consulta*/
//			//if (!STATE_VIEW.equals(getCurrentState())) {
//			//Se nгo tiver vindo da visualizaзгo, guarda. Caso contrбrio, nгo armazena
//			//pois a tela de visualizaзгo envia parвmetros vazios e sobrescreveria o da tela
//			//de consulta
//			//	requestContext.getPageFlowScope().put(SEARCH_PARAMETERS,
//			//		searchObject);
//			//	}
//			setCurrentState(STATE_EDIT);		
//		} else {
//			//Nгo altera estado, nгo selecionou ninguйm
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//							noItemSelectedMessage, null));
//		}
//		
//	}
//
//	/**
//	 * Retorna a entidade da linha selecionada na tabela
//	 */
//	@SuppressWarnings("unchecked")
//	protected Entity getSelectedRowEntity() {
//		if (tblData.getRowData() != null)
//			return (Entity) tblData.getRowData(); //getSelectedRowData();
//		else
//			return (Entity) tblData.getSelectedRowData();
//	}
//	
//	public void prepareInsert(ActionEvent event){		
//		/*salva os dados da pesquisa, digitados pelo usuбrio para posteriormente
//		restaurar quando voltar para a consulta*/
//		//requestContext.getPageFlowScope().put(SEARCH_PARAMETERS, searchObject);
//		//Cria nova instвncia para inserзгo
//		setEntity(getNewEntityInstance());
//		//Alterna os panels necessбrios para mostrar o conteъdo da inclusгo		
//		setCurrentState(STATE_INSERT);
//	}
//	
//	public void showSelected(ActionEvent event) {
//		
//		if (this.getSelectedRowEntity() != null) {
//			setEntity(getSelectedRowEntity());
//			
//			// Alterna os panels necessбrios para mostrar o conteъdo da
//			// visualizaзгo
//			setCurrentState(STATE_VIEW);
//		} else {
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//							noItemSelectedMessage, null));
//		}
//		
//	}
//	
//	public void prepareDelete(ActionEvent event){
//		if (this.getSelectedRowEntity() != null) {
//			setEntity(getSelectedRowEntity());
//
//			// Alterna os panels necessбrios para mostrar o conteъdo da exclusгo
//			setCurrentState(STATE_DELETE);
//		} else {
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//							noItemSelectedMessage, null));
//		}		
//	}
//	
//	public void delete(ActionEvent event){		
//		// parece que sу funciona quando a tr:table tem radio de seleзгo
////		setEntity(getSelectedRowEntity());
//
//		service.remove(getEntity());
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item excluнdo com sucesso."));
//		//refaz a busca
//		search(event);
//
//		setCurrentState(STATE_SEARCH);
//	}	
//	
//	
//	/**
//	 * Cancela a inclusгo / alteraзгo.
//	 * @param event
//	 */
//	public void cancel(ActionEvent event){
//		//Cancelar as operaзхes, volta para a consulta		
//		setCurrentState(STATE_SEARCH);
//		//limpa dos dados dos componentes de ediзгo
//		cleanSubmittedValues(pnlEditing);
//		//remove a entidade selecionada colocando uma nova, vazia no lugar
//		setEntity(getNewEntityInstance());
//	}
//	
//	/**
//	 * Limpa filtro de pesquisa
//	 */
//	public void cleanSearchObject(ActionEvent event) {
//		this.setSearchObject(getNewEntityInstance());
//		this.cleanSubmittedValues(event.getComponent().getParent());
//	}
//	
//	/**
//	 * Remove os dados armazenados na fase Apply Request Values para o componente de id igual a <code>idComp</code>. 
//	 * 
//	 * @param nomeComp
//	 */
//	protected void cleanSubmittedValues(String idComp) {		
//		UIComponent component = FacesContext.getCurrentInstance().getViewRoot().findComponent(idComp);
//		if (component != null)
//			cleanSubmittedValues(component);
//	}
//	/**
//	 * Limpa os dados dos componentes de ediзгo e de seus filhos, recursivamente.
//	 * 
//	 * Checa se o componente й instвncia de EditableValueHolder e 'reseta' suas propriedades.
//	 * 
//	 * @param component
//	 */
//	protected void cleanSubmittedValues(UIComponent component) {
//		if (component instanceof EditableValueHolder) {
//			EditableValueHolder evh = (EditableValueHolder) component;
//			evh.setSubmittedValue(null);
//			evh.setLocalValueSet(false);			
//			evh.setValid(true);			
//		}
//		if(component.getChildCount()>0){
//			for (UIComponent child : component.getChildren()) {
//				cleanSubmittedValues(child);
//			}
//		}
//	}
//	/**
//	 * Retorna o resultado da consulta armazenada no escopo de fluxo de pбgina. PageSlowScope.
//	 * Nesse caso, nгo hб um atributo para manter o resultado porque й necessбrio um scope
//	 * maior que o "request" e menor que o "session".
//	 * 
//	 * @return
//	 */
//	public CollectionDataModel getSearchResult() {
//		return  (CollectionDataModel) Faces.getPageFlowScope().get(this.getUniqueVariableName(SEARCH_RESULT));
//		
//	}
//	/**
//	 * Atribui o resultado para o pageFlowScope.
//	 * @param resultadoConsulta
//	 */
//	public void setSearchResult(CollectionDataModel result) {		
//		RequestContext.getCurrentInstance().getPageFlowScope().put(this.getUniqueVariableName(SEARCH_RESULT), result);
//	}
//	/**
//	 * Retorna o estado do fluxo do cadastro.
//	 * @return
//	 */
//	public String getCurrentState(){
//		return (String) RequestContext.getCurrentInstance().getPageFlowScope().get(this.getClass()+"currentState");
//	}
//	/**
//	 * Atribui o estado do fluxo do cadastro, apenas acessado internamente.
//	 * @param state
//	 */
//	protected void setCurrentState(String state){
//		RequestContext.getCurrentInstance().getPageFlowScope().put(this.getClass()+"currentState",state);
//	}
//	
//	/**
//	 * Retorna um componente que possua o id igual a <code>compId</code>.
//	 * @param compId Id do componente no ViewRoot
//	 * @return um componente que possua o id igual a <code>compId</code>.
//	 */
//	protected UIComponent findComponent(String compId){
//	   return FacesContext.getCurrentInstance().getViewRoot().findComponent(compId);	
//	}
//	public UIXTable getTblData() {
//		return tblData;
//	}
//	public void setTblData(UIXTable tblData) {
//		this.tblData = tblData;
//	}
//	public String getNoItemSelectedMessage() {
//		return noItemSelectedMessage;
//	}
//	public void setNoItemSelectedMessage(String noItemSelectedMessage) {
//		this.noItemSelectedMessage = noItemSelectedMessage;
//	}
//	public String getNoResultMessage() {
//		return noResultMessage;
//	}
//	public void setNoResultMessage(String noResultMessage) {
//		this.noResultMessage = noResultMessage;
//	}
//	@SuppressWarnings("unchecked")
//	public Entity getEntity() {
//		return (Entity) RequestContext.getCurrentInstance().getPageFlowScope().get(this.getUniqueVariableName(ENTITY));
//	}
//	public void setEntity(Entity entity) {
//		RequestContext.getCurrentInstance().getPageFlowScope().put(this.getUniqueVariableName(ENTITY),entity);
//	}
//	@SuppressWarnings("unchecked")
//	public Entity getSearchObject() {
//		return (Entity) RequestContext.getCurrentInstance().getPageFlowScope().get(this.getUniqueVariableName(SEARCH_PARAMETERS));
//	}
//	public void setSearchObject(Entity searchObject) {
//		RequestContext.getCurrentInstance().getPageFlowScope().put(
//				this.getUniqueVariableName(SEARCH_PARAMETERS), searchObject);
//	}
//	public Service getService() {
//		return service;
//	}
//	public void setService(Service service) {
//		this.service = service;
//	}
//	public UIComponent getPnlEditing() {
//		return pnlEditing;
//	}
//	public void setPnlEditing(UIComponent pnlEditing) {
//		this.pnlEditing = pnlEditing;
//	}
//	/**
//	 * Retorna <code>true</code> se o estado estiver em editing.
//	 * @return
//	 */
//	public boolean isEditing(){
//		return STATE_EDIT.equals(getCurrentState());
//	}
//	/**
//	 * Retorna <code>true</code> se o estado estiver em inserзгo.
//	 * @return
//	 */
//	public boolean isInserting(){
//		return STATE_INSERT.equals(getCurrentState());
//	}
//	/**
//	 * Retorna <code>true</code> se o estado estiver em exclusгo.
//	 * @return
//	 */
//	public boolean isDeleting(){
//		return STATE_DELETE.equals(getCurrentState());
//	}
//	/**
//	 * Retorna <code>true</code> se o estado estiver em visualizaзгo.
//	 * @return
//	 */
//	public boolean isViewing(){
//		return STATE_VIEW.equals(getCurrentState());
//	}
//	/**
//	 * Retorna <code>true</code> se o estado estiver em atualizaзгo, ou seja,
//	 * caso o estado esteja em ediзгo ou inserзгo ou exclusгo.
//	 * @return
//	 */
//	public boolean isUpdating() {
//		return (this.isEditing() || this.isInserting() || this.isDeleting());
//	}
//	/**
//	 * Retorna <code>true</code> se o estado estiver em busca.
//	 * @return
//	 */
//	public boolean isSearching(){
//		return (getCurrentState() == null || STATE_SEARCH.equals(getCurrentState()));
//	}
//	/**
//	 * Retorna tнtulo da pбgina atual
//	 * @return
//	 */
//	public String getTitleFromThePage() {
//		final String currentState = this.getCurrentState();// == null ? STATE_SEARCH : this.getCurrentState();
//		return titles.get(currentState);
//	}
//	/**
//	 * Retorna uma lista de critйrios de ordenaзгo utilizados como default na
//	 * grid de resultado de pesquisa. Por default nгo hб nenhum critйrio de
//	 * ordenaзгo, sendo, o mйtodo retorna <code>null</code>.
//	 */
//	protected List<SortCriterion> getDefaultSortCriteria() {
//		return null;
//	}
//	/**
//	 * Retorna uma chave ъnica para os parвmetros deste bean armazenados no
//	 * PageFlowScope
//	 */
//	protected String getUniqueVariableName(String key) {
//		String var = this.getClass().getSimpleName() + key;
//		return var;
//	}
}